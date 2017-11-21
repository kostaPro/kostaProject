package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.CommentService;
import service.EventService;

@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private CommentService commentService;

}
