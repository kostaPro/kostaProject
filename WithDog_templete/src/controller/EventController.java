package controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import domain.Comment;
import domain.Event;
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
	public String registEvent(Event event, MultipartHttpServletRequest file) {

		eventService.registEvent(event);
		return "redirect:eventDetail.jsp";
	}

	@RequestMapping(value = "/eventList.do", method = RequestMethod.GET)
	public ModelAndView showEventList() {

		return null;
	}

//	@RequestMapping(value = "/")
	public ModelAndView searchEvent(Date date, String location) {

		return null;
	}

	@RequestMapping(value = "/eventDetail.do")
	public ModelAndView showEventDetail(String eventId) {
		Event event = eventService.findEventByEventId(Integer.parseInt(eventId));
		ModelAndView modelAndView = new ModelAndView("eventDetail.jsp");
		modelAndView.addObject("eventDetail", event);
		
		return modelAndView;
	}

//	@RequestMapping("")
	public String joinEventMeeting(String eventId, Date date, HttpSession session) {
		
		return null;
	
	}

//	@RequestMapping("")
	public String cancelEventMeeting(String eventId, Date date, HttpSession session) {
		return null;
	}

	@RequestMapping(value = "modifyEvent.do", method=RequestMethod.GET)
	public ModelAndView showModifyEvent(String eventId) {
		
		Event event = eventService.findEventByEventId(Integer.parseInt(eventId));
		
		ModelAndView modelAndView = new ModelAndView("modifyEvent.jsp");
		modelAndView.addObject("event", event);
		
		return modelAndView;
		
	}

	@RequestMapping(value = "modifyEvent.do", method=RequestMethod.POST)
	public String modifyEvent(Event event, MultipartHttpServletRequest file){
		
		eventService.modifyEvent(event);
		
		return "redirect:/eventDetail.do?eventId="+ event.getEventId();
	}
	
	@RequestMapping(value = "removeEvent.do", method=RequestMethod.GET)
	public String removeEvent(String eventId) {
		
		eventService.removeEvent(Integer.parseInt(eventId));
		
		return "eventList.jsp";
	}

//	@RequestMapping("")
	public String registEventComment(String content, HttpSession session, String eventId, String parentId) {
		return null;
	}

//	@RequestMapping("")
	public String modifyEventComment(Comment comment) {
		return null;
	}

//	@RequestMapping("")
	public String deleteEventComment(String commentId) {
		return null;
	}

}
