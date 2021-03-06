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

import javax.servlet.http.HttpServletRequest;
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
import domain.Report;
import domain.Spot;
import domain.User;
import service.CommentService;
import service.EventService;
import service.ReportService;
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
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReportService reportService;

	
	

	@RequestMapping(value = "/registEvent.do", method = RequestMethod.GET)
	public String showRegistEvent() {

		return "registEvent.jsp";
	}

	@RequestMapping(value = "/registEvent.do", method = RequestMethod.POST)
	public String registEvent(Event event, String spotId, MultipartHttpServletRequest file) throws IOException {

		Spot eventSpot = new Spot();
		eventSpot.setSpotId(Integer.parseInt(spotId));
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

	@RequestMapping(value = "/adminPage_event.do", method = RequestMethod.GET)
	public ModelAndView showAdminEventList() {

		List<Event> eventList = eventService.findAllEvents();

		ModelAndView modelAndView = new ModelAndView("adminPage_event.jsp");
		modelAndView.addObject("eventList", eventList);

		return modelAndView;
	}

	@RequestMapping(value = "/eventList.do", method = RequestMethod.GET)
	public ModelAndView showEventList(HttpSession session) {

		
		User user = (User) session.getAttribute("loginUser");
		List<Event> eventList = eventService.findAllEvents();

		ModelAndView modelAndView = new ModelAndView("eventList.jsp");
		modelAndView.addObject("loginUser", user);
		modelAndView.addObject("eventList", eventList);

		return modelAndView;
	}

	@RequestMapping(value = "/eventList.do", method = RequestMethod.POST)
	public ModelAndView searchEvent(@RequestParam("spotLocation") String location,
			@RequestParam("date") String inputDate) {

		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy");
		Date date = null;
		try {
			if(!inputDate.equals("")) {
				date = dateFormatter.parse(inputDate);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<Event> eventList = new ArrayList<>();
		ModelAndView modelAndView = new ModelAndView("eventList.jsp");

		if (location == "" && date != null) {

			eventList = eventService.findEventsByDate(date);

			modelAndView.addObject("eventList", eventList);

			return modelAndView;

		} else if (location != "" && date == null) {

			eventList = eventService.findEventsByLocation(location);

			modelAndView.addObject("eventList", eventList);

			return modelAndView;

		} else if (location != "" && date != null) {

			eventList = eventService.findEventsByDateLocation(date, location);

			modelAndView.addObject("eventList", eventList);

			return modelAndView;

		} else if (location == "" && date == null) {
			eventList = eventService.findAllEvents();

			modelAndView.addObject("eventList", eventList);

			return modelAndView;
		} else {
			return null;
		}

	}

	@RequestMapping(value = "/eventDetail.do")
	public ModelAndView showEventDetail(String eventId, HttpSession session) throws ParseException {

		Event event = eventService.findEventByEventId(Integer.parseInt(eventId));

		List<Comment> comment = event.getCommentList();
		User user = (User)session.getAttribute("loginUser");

		ModelAndView modelAndView = new ModelAndView("eventDetail.jsp");
		modelAndView.addObject("eventDetail", event);
		modelAndView.addObject("fullJoinList", event.getEventJoinLists());
		modelAndView.addObject("loginUser", user);
		modelAndView.addObject("eventSpot",event.getEventSpot());

		modelAndView.addObject("comment", comment);
		return modelAndView;
	}

	@RequestMapping(value = "/joinEvent.do", method = RequestMethod.GET)
	public String joinEventMeeting(String eventId, String date, HttpSession session) throws ParseException {

		User guest = (User) session.getAttribute("loginUser");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date joinDate = format.parse(date);
		eventService.joinEventMeeting(Integer.parseInt(eventId), guest.getUserId(), joinDate);

		return "redirect:eventDetail.do?eventId=" + eventId;
	}

	@RequestMapping(value = "/cancelEvent.do", method = RequestMethod.GET)
	public String cancelEventMeeting(String eventId, String date, HttpSession session) throws ParseException {

		User guest = (User) session.getAttribute("loginUser");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date joinDate = format.parse(date);
		eventService.cancelEventMeeting(Integer.parseInt(eventId), guest.getUserId(), joinDate);

		return "redirect:eventDetail.do?eventId=" + eventId;
	}

	@RequestMapping(value = "/modifyEvent.do", method = RequestMethod.GET)
	public ModelAndView showModifyEvent(String eventId) {

		Event event = eventService.findEventByEventId(Integer.parseInt(eventId));

		ModelAndView modelAndView = new ModelAndView("modifyEvent.jsp");
		modelAndView.addObject("event", event);

		return modelAndView;
	}

	@RequestMapping(value = "/modifyEvent.do", method = RequestMethod.POST)
	public String modifyEvent(Event event, String spotId, MultipartHttpServletRequest file) {
		
		Spot eventSpot = new Spot();
		eventSpot.setSpotId(Integer.parseInt(spotId));
		event.setEventSpot(eventSpot);
		
		eventService.modifyEvent(event);

		return "redirect:eventDetail.do?eventId=" + event.getEventId();
	}

	@RequestMapping(value = "/removeEvent.do", method = RequestMethod.GET)
	public String removeEvent(String eventId) {

		eventService.removeEvent(Integer.parseInt(eventId));

		return "redirect:eventList.do";
	}

	@RequestMapping(value = "/registEventComment.do", method = RequestMethod.POST)
	public ModelAndView registEventComment(Comment comment, String eventId, HttpSession session) {
		User user = (User) session.getAttribute("loginUser");

		comment.setWriterId(user.getUserId());
		comment.setTargetId(Integer.parseInt(eventId));
		commentService.registEventComment(comment); 

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		return modelAndView;
	}

	@RequestMapping(value = "/modifyEventComment.do", method = RequestMethod.POST)
	public ModelAndView modifyEventComment(Comment comment, String commentId, String eventId) {

		comment.setCommentId(Integer.parseInt(commentId));
		commentService.modifyEventComment(comment);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		return modelAndView;
	}

	@RequestMapping("/removeEventComment.do")
	public ModelAndView removeEventComment(String commentId, String parentId, String eventId, HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();

		User user = (User) session.getAttribute("loginUser");
		if (user.getUserId().equals("admin")) {

			Report report = new Report();

			report.setReportTargetId(Integer.parseInt(eventId));
			report.setReportType("eventComment");
			report.setStatus("O");
			report.setReportContent("관리자 신고");
			report.setReporterId("admin");

			reportService.registReport(report);

			commentService.removeEventComment(Integer.parseInt(commentId));
			modelAndView.setViewName("jsonView");
			return modelAndView;

		} else {

			commentService.removeEventComment(Integer.parseInt(commentId));
			modelAndView = new ModelAndView();
			modelAndView.setViewName("jsonView");
			return modelAndView;
		}
	}

}
