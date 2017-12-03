package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import domain.Comment;
import domain.Event;
import domain.Spot;
import domain.User;
import service.CommentService;
import service.EventService;
import service.SpotService;
import service.UserService;

@Controller
public class EventController {

	// +showRegistEvent() : String
	// +registEvent(event : Event, file : MultipartHttpServletRequest) : String
	// +showEventList() : ModelAndView
	// +searchEvent(date : Date, location : String) : ModelAndView
	// +showEventDetail(eventId : String) : ModelAndView
	// +joinEventMeeting(eventId : String, date : Date, session : HttpSession) :
	// String
	// +cancelEventMeeting(eventId : String, date : Date, session : HttpSession) :
	// String
	// +showModifyEvent(eventId : String) : ModelAndView
	// +modifyEvent(event : Event, file : MultipartHttpServletRequest) : String
	// +removeEvent(eventId : String) : String
	// +registEventComment(content : String, session : HttpSession, eventId :
	// String, parentId : String) : String
	// +modifyEventComment(comment : Comment): String
	// +removeEventComment(commentId : String): String

	@Autowired
	private EventService eventService;

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/registEvent.do", method = RequestMethod.GET)
	public String showRegistEvent() {

		return "registEvent.jsp";
	}

	@RequestMapping(value = "/registEvent.do", method = RequestMethod.POST)
	public String registEvent(Event event, MultipartHttpServletRequest file) throws IOException {

		Spot eventSpot = new Spot();
		eventSpot.setSpotId(15);
		event.setEventSpot(eventSpot);

		String realFolder = "c:\\" + File.separator + "tempFiles";
		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		MultipartFile thumbnail = file.getFile("eventImg");
		if (thumbnail == null && thumbnail.getOriginalFilename().equals("")) {

		} else {
			// 파일 중복명 처리
			String genId = UUID.randomUUID().toString();
			// 본래 파일명
			String originalfileName = thumbnail.getOriginalFilename();
			// 저장되는 파일 이름
			String saveFileName = genId + "." + originalfileName;

			File saveFile = new File(dir.getAbsolutePath() + File.separator + saveFileName);

			byte[] bytes = thumbnail.getBytes();

			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
			out.write(bytes);
			out.close();

			event.setEventImage(saveFileName);
		}

		eventService.registEvent(event);

		return "redirect:eventDetail.do?eventId=" + event.getEventId();
	}

	@RequestMapping(value = "/eventList.do", method = RequestMethod.GET)
	public ModelAndView showEventList() {

		List<Event> eventList = eventService.findAllEvents();

		ModelAndView modelAndView = new ModelAndView("eventList.jsp");
		modelAndView.addObject("eventList", eventList);

		return modelAndView;
	}

// 
	@RequestMapping(value = "/eventList.do", method = RequestMethod.POST)
	public ModelAndView searchEvent(@RequestParam("spotLocation") String location, @RequestParam("date") @DateTimeFormat(pattern = "yy-MM-dd") Date date) {

		List<Event> eventList = new ArrayList<>();
		ModelAndView modelAndView = new ModelAndView();
			
		if (location == null && date != null) {
		
		eventList = eventService.findEventsByDate(date);
		
		modelAndView = new ModelAndView("eventList.jsp");
		modelAndView.addObject("eventList", eventList);

		return modelAndView;

		} else if(location != null && date == null) {

			eventList = eventService.findEventsByLocation(location);
			
			modelAndView = new ModelAndView("eventList.jsp");
			modelAndView.addObject("eventList", eventList);

			return modelAndView;

		} else {

			eventList = eventService.findEventsByDateLocation(date, location);
			
			modelAndView = new ModelAndView("eventList.jsp");
			modelAndView.addObject("eventList", eventList);

			return modelAndView;

		}

	}

	@RequestMapping(value = "/eventDetail.do")
	public ModelAndView showEventDetail(String eventId) {
		Event event = eventService.findEventByEventId(Integer.parseInt(eventId));
	
		ModelAndView modelAndView = new ModelAndView("eventDetail.jsp");
		modelAndView.addObject("eventDetail", event);

		return modelAndView;
	}

	// @RequestMapping("")
	public String joinEventMeeting(String eventId, Date date, HttpSession session) {

		String guestId = (String) session.getAttribute("userId");
		eventService.joinEventMeeting(Integer.parseInt(eventId), guestId, date);

		return null;// 그냥 단순히 조인하는건데?ㅠ어디로 보낼라고?ㅠ
	}

	// @RequestMapping("")
	public String cancelEventMeeting(String eventId, Date date, HttpSession session) {

		String guestId = (String) session.getAttribute("userId");
		eventService.cancelEventMeeting(Integer.parseInt(eventId), guestId, date);

		return null;
	}

	@RequestMapping(value = "/modifyEvent.do", method = RequestMethod.GET)
	public ModelAndView showModifyEvent(String eventId) {

		Event event = eventService.findEventByEventId(Integer.parseInt(eventId));

		ModelAndView modelAndView = new ModelAndView("modifyEvent.jsp");
		modelAndView.addObject("event", event);

		return modelAndView;
	}

	@RequestMapping(value = "/modifyEvent.do", method = RequestMethod.POST)
	public String modifyEvent(Event event, MultipartHttpServletRequest file) {

		Spot eventSpot = new Spot();
		eventSpot.setSpotId(17);
		event.setEventSpot(eventSpot);

		eventService.modifyEvent(event);

		return "redirect:eventDetail.do?eventId=" + event.getEventId();
	}

	@RequestMapping(value = "/removeEvent.do", method = RequestMethod.GET)
	public String removeEvent(String eventId) {

		eventId = "47";

		eventService.removeEvent(Integer.parseInt(eventId));

		return "eventList.jsp";
	}

	// @RequestMapping("")
	public String registEventComment(String content, HttpSession session, String eventId, String parentId) {
		return null;
	}

	// @RequestMapping("")
	public String modifyEventComment(Comment comment) {

		commentService.modifyEventComment(comment);
		return null;

	}

	// @RequestMapping("")
	public String deleteEventComment(String commentId) {
		return null;
	}

}
