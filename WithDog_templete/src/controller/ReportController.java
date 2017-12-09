package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Report;
import domain.User;
import domain.BlackList;
import service.ReportService;
import service.UserService;

@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	

	@RequestMapping(value = "/registReport.do", method = RequestMethod.GET)
	public ModelAndView showRegistReport(String reportType, String reportTargetId) {

		ModelAndView modelAndView = new ModelAndView("registReport.jsp");

		modelAndView.addObject("reportTargetId", reportTargetId);
		modelAndView.addObject("reportType", reportType);

		return modelAndView;
	}

	@RequestMapping(value = "/registReport.do", method = RequestMethod.POST)
	public String registReport(Report report, HttpSession session,
			@RequestParam("reportContent") String reportContent) {

		User user = (User) session.getAttribute("loginUser");
		String userId = user.getUserId();

		if (userId.equals("admin")) {
			report.setStatus("O");
		} else {
			report.setStatus("-");
		}

		report.setReporterId(userId);
		report.setReportContent(reportContent);

		reportService.registReport(report);

		return "redirect:userPage_report.do?reporterId=" + report.getReporterId();
	}

	@RequestMapping(value = "/userPage_report.do")
	public ModelAndView showUserReport(HttpSession session) {

		User user = (User) session.getAttribute("loginUser");
		String reporterId = user.getUserId();

		List<Report> userReportList = reportService.findReportsByReporterId(reporterId);

		ModelAndView modelAndView = new ModelAndView("userPage_report.jsp");
		modelAndView.addObject("userReportList", userReportList);

		return modelAndView;
	}

	@RequestMapping(value = "/adminPage_searchByReportType.do")
	public ModelAndView showSearchByReportType(String reportType) {

		String meeting = "meeting";
		String spot = "spot";
		String review = "review";
		String eventComment = "eventComment";
		String reviewComment = "reviewComment";
		String meetingComment = "meetingComment";

		List<Report> meetingReport = reportService.findReportsByReportType(meeting);
		List<Report> spotReport = reportService.findReportsByReportType(spot);
		List<Report> reviewReport = reportService.findReportsByReportType(review);

		List<Report> eventCommentReport = reportService.findReportsByReportType(eventComment);
		List<Report> reviewCommentReport = reportService.findReportsByReportType(reviewComment);
		List<Report> meetingCommentReport = reportService.findReportsByReportType(meetingComment);

		ModelAndView modelAndView = new ModelAndView("adminPage_searchByReportType.jsp");

		modelAndView.addObject("meetingReport", meetingReport);
		modelAndView.addObject("spotReport", spotReport);
		modelAndView.addObject("reviewReport", reviewReport);

		modelAndView.addObject("eventCommentReport", eventCommentReport);
		modelAndView.addObject("reviewCommentReport", reviewCommentReport);
		modelAndView.addObject("meetingCommentReport", meetingCommentReport);

		return modelAndView;
	}

	@RequestMapping(value = "/adminPage_blackList.do")
	public ModelAndView showBlackList() {

		List<BlackList> blackList = reportService.findBlackList();

		ModelAndView modelAndView = new ModelAndView("adminPage_blackList.jsp");
		modelAndView.addObject("blackList", blackList);

		return modelAndView;
	}

	@RequestMapping(value = "/adminPage_suspectDetail.do")
	public ModelAndView showSuspectReport(String suspectId) { // 용의자 아이디로 모든신고 이력조회

		List<Report> suspectDetailList = reportService.findReportsBySuspectId(suspectId);

		ModelAndView modelAndView = new ModelAndView("adminPage_suspectDetail.jsp");
		modelAndView.addObject("suspectDetailList", suspectDetailList);

		return modelAndView;

	}

	// 필요없는듯 하다.
	public ModelAndView showModifyReport(String reportId) {

		return null;
	}

	@RequestMapping(value = "/modifyReport.do")
	public String modifyReport(Report report) { // 관리자가 myPage에서 처리상태를 수정

		// String reportType = "spot";
		// report.setReportType(reportType);

		reportService.modifyReport(report);

		return "adminPage_searchByReportType.do";
	}

	public String removeReport(String reportTargetId) {

		reportService.removeReport(Integer.parseInt(reportTargetId));

		return "userReport.do";

	}
	
	
	
}
