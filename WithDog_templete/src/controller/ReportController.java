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

		String userId = "sy";
		reportType = "spot"; // hidden으로 reportType 넘어올것.
		reportTargetId = "1211"; // hidden으로 넘어온 고유Id(eventId등등)이 reportTargetId가 될것.

		ModelAndView modelAndView = new ModelAndView("registReport.jsp");

		modelAndView.addObject("userId", userId);
		modelAndView.addObject("reportTargetId", reportTargetId);
		modelAndView.addObject("reportType", reportType);

		return modelAndView;
	}

	@RequestMapping(value = "/registReport.do", method = RequestMethod.POST)
	public String registReport(Report report, HttpSession session, @RequestParam("reportContent") String reportContent) {

		// String userId = (String)session.getAttribute("userId");
		String userId = "sy";

		if (userId.equals("admin")) {
			report.setStatus("O");
		} else {
			report.setStatus("-");
		}

		report.setReporterId(userId);
		report.setReportContents(reportContent);

		reportService.registReport(report);

		return "redirect:userReport.do?reporterId=" + report.getReporterId();
	}

	@RequestMapping(value = "/userReport.do")
	public ModelAndView showUserReport(HttpSession session) {
		
		//String reportId = (String)session.getAttribute("userId");
		
		String reporterId = "sy";

		List<Report> userReportList = reportService.findReportsByReporterId(reporterId);

		ModelAndView modelAndView = new ModelAndView("userReport.jsp");
		modelAndView.addObject("userReportList", userReportList);

		return modelAndView;
	}


	@RequestMapping(value = "/adminPage_searchByReportType.do")
	public ModelAndView showSearchByReportType(String reportType) {

		String meeting = "meeting";
		String spot = "spot";
		String review = "review";
		String comment = "comment";
		
		List<Report> meetingReport = reportService.findReportsByReportType(meeting);
		List<Report> spotReport = reportService.findReportsByReportType(spot);
		List<Report> reviewReport = reportService.findReportsByReportType(review);
		List<Report> commentReport = reportService.findReportsByReportType(comment);
		
		ModelAndView modelAndView = new ModelAndView("adminReport.jsp");
		
		modelAndView.addObject("meetingReport", meetingReport);
		modelAndView.addObject("spotReport", spotReport);
		modelAndView.addObject("reviewReport", reviewReport);
		modelAndView.addObject("commentReport", commentReport);

		return modelAndView;
	}

	@RequestMapping(value = "/adminPage_blackList.do")
	public ModelAndView showBlackList() {

		List<BlackList> blackList = reportService.findBlackList();

		ModelAndView modelAndView = new ModelAndView("blackList.jsp");
		modelAndView.addObject("blackList", blackList);

		return modelAndView;
	}

	@RequestMapping(value = "/adminPage_suspectDetail.do")
	public ModelAndView showSuspectReport(String suspectId) { // 용의자 아이디로 모든신고 이력조회

		List<Report> suspectDetailList = reportService.findReportsBySuspectId(suspectId);

		ModelAndView modelAndView = new ModelAndView("suspectDetail.jsp");
		modelAndView.addObject("suspectDetailList", suspectDetailList);

		return modelAndView;

	}

	// 필요없는듯 하다.
	public ModelAndView showModifyReport(String reportId) {

		return null;
	}

	@RequestMapping(value = "/modifyReport.do")
	public String modifyReport(Report report) { // 관리자가 myPage에서 처리상태를 수정

		reportService.modifyReport(report);

		return "adminReport.do";
	}

	public String removeReport(String reportTargetId) {

		reportService.removeReport(Integer.parseInt(reportTargetId));

		return "userReport.do";

	}
}
