package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import domain.Meeting;
import service.CommentService;
import service.MeetingService;

@Controller
public class MeetingController {
	
	@Autowired
	private MeetingService meetingService;
	@Autowired
	private CommentService commentService;

	
	@RequestMapping(value = "/registMeeting.do", method = RequestMethod.GET)
	public String showRegistMeeting() {
		
		return "registMeeting.jsp";
	}

//	public String registMeeting(Meeting meeting, HttpSession session, MultipartHttpServletRequest file) {
//		
//		
//		
//	}
	
}
