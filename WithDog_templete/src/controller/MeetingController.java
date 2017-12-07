package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import domain.Meeting;
import domain.Spot;
import domain.User;
import service.CommentService;
import service.MeetingService;
import service.SpotService;
import service.UserService;

@Controller
public class MeetingController {
	
///	+showRegistMeeting() : String
///	+registMeeting(meeting : Meeting, session : HttpSession, file : MultipartHttpServletRequest) : String
//	+showMeetingList() : ModelAndView
//	+joinMeeting(meetingId : int, session : HttpSession) : String
//	+cancelMeeting(meetingId : int, session : HttpSession) : String
//	+searchMeetingList(location : String, date : Date) : ModelAndView
//	+showMyMeeting(session : HttpSession) : ModelAndView
///	+showMeetingDetail(meetingId : String) : ModelAndView
//	+showModifyMeeting(meetingId : String) : ModelAndView
//	+modifyMeeting(meeting : Meeting, file : MultipartHttpServletRequest) : String
//	+removeMeeting(meetingId : String, session : HttpSession) : String
//	+registMeetingComment(content : String, session : HttpSession, reviewId : String) : String 
//	+modifyMeetingComment(comment : Comment): String
//	+removeMeetingComment(commentId : String): String

	
	@Autowired
	private MeetingService meetingService;
	@Autowired
	private UserService userService;
	@Autowired
	private SpotService spotService;
	@Autowired
	private CommentService commentService;

	
	@RequestMapping(value = "/registMeeting.do", method = RequestMethod.GET)
	public String showRegistMeeting(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		session.setAttribute("userId", session.getId());

		return "registMeeting.jsp";
	}
	
	
	@RequestMapping(value = "/registMeeting.do", method = RequestMethod.POST)
	public String registMeeting(Meeting meeting, String spotId, HttpSession session, MultipartHttpServletRequest file) throws IOException {
		
		User user = (User)session.getAttribute("loginUser");
		
		Spot meetingSpot = new Spot();
		meetingSpot.setSpotId(Integer.parseInt(spotId));
		
		meeting.setMeetingSpot(meetingSpot);
		meeting.setHostId(user.getUserId());
		meetingService.registMeeting(meeting);
		
		
		String realFolder = "c:\\" + File.separator + "tempFiles";
		File dir = new File(realFolder);
		if(!dir.isDirectory()) {
			dir.mkdirs();
		}
		
		List<MultipartFile> mf = file.getFiles("file");
		if(mf.size() == 0 && mf.get(0).getOriginalFilename().equals("")) {
			
		} else {
			for(int i = 0; i < mf.size(); i++) {
				String genId = UUID.randomUUID().toString();
				
				String originalFileName = mf.get(i).getOriginalFilename();
				
				String saveFileName = genId + "." + originalFileName;
			
				File saveFile = new File(dir.getAbsolutePath() + File.separator + saveFileName);
				
				byte[] bytes = mf.get(i).getBytes();
				
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
				out.write(bytes);
				out.close();
				
				meetingService.registMeetingImage(saveFileName, meeting.getMeetingId());
			}
		}
		
		
		
		return "redirect:meetingDetail.do?meetingId=" + meeting.getMeetingId();
	}
	
	@RequestMapping("/meetingDetail.do")
	public ModelAndView showMeetingDetail(String meetingId, HttpSession session) {
		Meeting meeting = meetingService.findMeetingByMeetingId(Integer.parseInt(meetingId));

		User user = (User)session.getAttribute("loginUser");
		User userId = userService.findUserByUserId(user.getUserId());
		userId.getPetImage();
		List<String> joinList = meeting.getMeetingJoinList();
		List<String> meetingList = meeting.getMeetingImageList();
//		List<User> userList = userService.findUserList(joinList);
		List<Comment> comment = meeting.getCommentList(); 

		ModelAndView modelAndView = new ModelAndView("meetingDetail.jsp");
		modelAndView.addObject("meetingDetail", meeting);
		modelAndView.addObject("meetingSpot", meeting.getMeetingSpot());
		modelAndView.addObject("ImageList", meetingList);
		modelAndView.addObject("joinList", joinList);
//		modelAndView.addObject("userList", userList);
		modelAndView.addObject("User", user);
		modelAndView.addObject("user", userId);
		modelAndView.addObject("comment", comment);
		return modelAndView;
	}
	
	@RequestMapping(value = "/meetingList.do", method = RequestMethod.GET)
	public ModelAndView showMeetingList() {
		
		List<Meeting> meetingList = meetingService.findAllMeetings();
		
		ModelAndView modelAndView = new ModelAndView("meetingList.jsp");
		modelAndView.addObject("meetingList", meetingList);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "meetingList.do", method = RequestMethod.POST)
	public ModelAndView searchMeeting(@RequestParam("mLocation") String location,@RequestParam("date") @DateTimeFormat(pattern = "yy-MM-dd") Date date) {
		
		List<Meeting> meetingList = new ArrayList<>();
		
		if(location == "" && date != null) {
			meetingList = meetingService.findMeetingsByDate(date);
			
			ModelAndView modelAndView = new ModelAndView("meetingList.jsp");
			modelAndView.addObject("meetingList", meetingList);
			
			return modelAndView;
		}else if(location != null && date == null){
			meetingList = meetingService.findMeetingsByLocation(location);
			
			ModelAndView modelAndView = new ModelAndView("meetingList.jsp");
			modelAndView.addObject("meetingList", meetingList);
			
			return modelAndView;
		}else if(location != null && date != null) {
			meetingList = meetingService.findMeetingsByLocationDate(location, date);
			
			ModelAndView modelAndView = new ModelAndView("meetingList.jsp");
			modelAndView.addObject("meetingList", meetingList);
			
			return modelAndView;
		}else if(location == "" && date == null){
			meetingList = meetingService.findAllMeetings();
			
			ModelAndView modelAndView = new ModelAndView("meetingList.jsp");
			modelAndView.addObject("meetingList", meetingList);
			
			return modelAndView;
		}else {
			return null;
		}
		
	}
	
	@RequestMapping(value = "/modifyMeeting.do", method = RequestMethod.GET)
	public ModelAndView showModifyMeeting(String meetingId){
		
		Meeting meeting = meetingService.findMeetingByMeetingId(Integer.parseInt(meetingId));
		
		ModelAndView modelAndView = new ModelAndView("modifyMeeting.jsp");
		modelAndView.addObject("meetingDetail", meeting);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/modifyMeeting.do", method = RequestMethod.POST)
	public String modifyMeeting(Meeting meeting){
		
		Spot meetingSpot = new Spot();
		meetingSpot.setSpotId(1);
		
		meeting.setMeetingSpot(meetingSpot);
		
		
		meetingService.modifyMeeting(meeting);
		
		return "redirect:meetingDetail.do?meetingId=" + meeting.getMeetingId();
	}
	
	@RequestMapping(value = "/myMeetingList.do")
	public ModelAndView showMyMeeting(HttpSession session) {
		
		User user = (User)session.getAttribute("loginUser");
		List<Meeting> hostList = meetingService.findMeetingsByHost(user.getUserId());
		List<Meeting> joinList = meetingService.findMeetingsByGuest(user.getUserId());
		
		ModelAndView modelAndView = new ModelAndView("myMeetingList.jsp");
		modelAndView.addObject("hostList", hostList);
		modelAndView.addObject("joinList", joinList);
		
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/myModifyMeeting.do", method = RequestMethod.GET)
	public ModelAndView showMyModifyMeeting(String meetingId){
		
		Meeting meeting = meetingService.findMeetingByMeetingId(Integer.parseInt(meetingId));
		
		ModelAndView modelAndView = new ModelAndView("myModifyMeeting.jsp");
		modelAndView.addObject("meetingDetail", meeting);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/myModifyMeeting.do", method = RequestMethod.POST)
	public ModelAndView myModifyMeeting(Meeting meeting){
		
		Spot meetingSpot = new Spot();
		meetingSpot.setSpotId(1);
		meeting.setMeetingSpot(meetingSpot);
		
		meetingService.modifyMeeting(meeting);
		
		List<Meeting> hostList = meetingService.findMeetingsByHost(meeting.getHostId());
		List<Meeting> joinList = meetingService.findMeetingsByGuest(meeting.getHostId());
		
		ModelAndView modelAndView = new ModelAndView("myMeetingList.jsp");
		modelAndView.addObject("hostList", hostList);
		modelAndView.addObject("joinList", joinList);
		
		return modelAndView;
	}
	
	
	@RequestMapping("/removeMeeting.do")
	public String removeMeeting(String meetingId) {

		
			meetingService.removeMeeting(Integer.parseInt(meetingId));

			return "redirect:meetingList.do";
	}
	
	
	@RequestMapping("/myRemoveMeeting.do")
	public String myRemoveMeeting(String meetingId, HttpSession session) {

		User user = (User)session.getAttribute("loginUser");
		if(user.getUserId().equals("admin")) {
//					서윤아 관리자 신고&삭제할때 이부분에서 쓰면 됨!
//					일해라 강서윤
			return "adminReport.do";
		}else {
			meetingService.removeMeeting(Integer.parseInt(meetingId));

			return "redirect:myMeetingList.do";
		}
	}
	
	@RequestMapping(value = "/registMeetingComment.do", method = RequestMethod.POST)
	public ModelAndView registMeetingComment(Comment comment, String meetingId, HttpSession session) {
		User user = (User) session.getAttribute("loginUser");
		
		comment.setWriterId(user.getUserId());
		comment.setTargetId(Integer.parseInt(meetingId));
		commentService.registMeetingComment(comment);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		return modelAndView;
	}
	
	@RequestMapping(value = "/modifyMeetingComment.do", method = RequestMethod.POST)
	public ModelAndView modifyMeetingComment(Comment comment, String commentId, String meetingId) {
		
		comment.setCommentId(Integer.parseInt(commentId));
		commentService.modifyMeetingComment(comment);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		return modelAndView;
	}
	
	@RequestMapping("/removeMeetingComment.do")
	public ModelAndView removeMeetingComment(String commentId, String parentId, String meetingId) {

		commentService.removeMeetingComment(Integer.parseInt(commentId));
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		return modelAndView;
	}
	
	
}
