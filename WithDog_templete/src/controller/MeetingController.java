package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.CommentService;
import service.MeetingService;

@Controller
public class MeetingController {
	
	@Autowired
	private MeetingService meetingService;
	@Autowired
	private CommentService commentService;


}
