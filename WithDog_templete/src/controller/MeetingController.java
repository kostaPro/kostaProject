package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import domain.Meeting;
import domain.Spot;
import domain.User;
import service.CommentService;
import service.MeetingService;

@Controller
public class MeetingController {
	
	@Autowired
	private MeetingService meetingService;
	@Autowired
	private CommentService commentService;

	
	@RequestMapping(value = "/registMeeting.do", method = RequestMethod.GET)
	public String showRegistMeeting(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		session.setAttribute("userId", session.getId());

		return "registMeeting.jsp";
	}
	@RequestMapping(value = "/registMeeting.do", method = RequestMethod.POST)
	public String registMeeting(Meeting meeting) throws IOException {
		
		Spot meetingSpot = new Spot();
		meetingSpot.setSpotId(1);
		
		meeting.setMeetingSpot(meetingSpot);
//		meeting.setHostId(session.getId());

		meeting.setHostId("uraid");
		
		meeting.setMeetingTime(2);
		meeting.setMinPerson(3);
		
		
		
//		String realFolder = "c:\\" + File.separator + "tempFiles";
//		File dir = new File(realFolder);
//		if(!dir.isDirectory()) {
//			dir.mkdirs();
//		}
		
//		List<MultipartFile> mf = file.getFiles("file");
//		if(mf.size() == 0 && mf.get(0).getOriginalFilename().equals("")) {
//			
//		} else {
//			for(int i = 0; i < mf.size(); i++) {
//				String genId = UUID.randomUUID().toString();
//				
//				String originalFileName = mf.get(i).getOriginalFilename();
//				
//				String saveFileName = genId + "." + originalFileName;
//			
//				File saveFile = new File(dir.getAbsolutePath() + File.separator + saveFileName);
//				
//				byte[] bytes = mf.get(i).getBytes();
//				
//				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
//				out.write(bytes);
//				out.close();
//				
//				meetingService.registMeetingImage(saveFileName, meeting.getMeetingId());
//			}
//		}
		meetingService.registMeeting(meeting);
		return "redirect:login.jsp";
//		return "redirect:meetingDetail.do?meetingId=" + meeting.getMeetingId();
	}
	
}
