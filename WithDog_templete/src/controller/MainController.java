package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value="/main.do",method=RequestMethod.GET)
	public ModelAndView showMainPage(HttpSession session) throws ParseException {

		User user = (User) session.getAttribute("loginUser");
		ModelAndView modelAndView = new ModelAndView("main.jsp");

		List<Event> eventList = eventService.findAllEvents();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy");
		Date date = new Date();
		
		Date today = dateFormatter.parse(dateFormatter.format(date));
		
		List<Meeting> meetingList = meetingService.findMeetingsByLocationDate(user.getFavoriteLocation(), today);

		modelAndView.addObject("eventList", eventList);
		modelAndView.addObject("meetingList", meetingList);
		

		return modelAndView;
	}
	
	@RequestMapping(value="/main.do",method=RequestMethod.POST)
	public ModelAndView refreshMainPage(HttpSession session, String spotLocation) throws ParseException {

		User user = (User) session.getAttribute("loginUser");
		ModelAndView modelAndView = new ModelAndView("main.jsp");

		List<Event> eventList = eventService.findAllEvents();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy");
		Date date = new Date();
		
		Date today = dateFormatter.parse(dateFormatter.format(date));
		
		List<Meeting> meetingList = meetingService.findMeetingsByLocationDate(spotLocation, today);

		modelAndView.addObject("eventList", eventList);
		modelAndView.addObject("meetingList", meetingList);
		

		return modelAndView;
	}

	

}
