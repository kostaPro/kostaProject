package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.Event;
import domain.Meeting;
import domain.User;
import service.EventService;
import service.MeetingService;

@Controller
public class MainController {

	@Autowired
	private EventService eventService;

	@Autowired
	private MeetingService meetingService;
	
	@RequestMapping("/main.do")
	public ModelAndView showMainPage(HttpSession session) {
		
		User user = (User)session.getAttribute("loginUser");
		ModelAndView modelAndView = new ModelAndView("main.jsp");
		
		List<Event> eventList = eventService.findAllEvents();
		Date today = new Date();
		List<Meeting> meetingList = meetingService.findMeetingsByLocationDate(user.getFavoriteLocation(), today);
		
		modelAndView.addObject("eventList",eventList);
		modelAndView.addObject("meetingList",meetingList);
		
		return modelAndView;
	}
}
