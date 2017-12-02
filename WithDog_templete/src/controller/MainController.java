package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.Event;
import service.EventService;

@Controller
public class MainController {

	@Autowired
	private EventService eventService;
	
	@RequestMapping("/main.do")
	public ModelAndView showMainPage() {
		
		ModelAndView modelAndView = new ModelAndView("test.jsp");
		
		List<Event> eventList = eventService.findAllEvents();
		
		modelAndView.addObject("eventList",eventList);
		
		return modelAndView;
	}
}
