package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Report;
import domain.User;
import service.ReportService;
import service.UserService;

@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;

	// +showRegistReport(reportType : String, targetId : String) : ModelAndView
	// +registReport(report : Report, session : HttpSession) : String
	// +showUserReport(session : HttpSession) : ModelAndView
	// +showAdminReport() : ModelAndView
	// +showSearchByReportType(reportType : String) : ModelAndView
	// +showBlackList() : ModelAndView
	// +showSuspectReport(suspectId : String) : ModelAndView
	// +showModifyReport(reportId : String) : ModelAndView
	// +modifyReport(report : Report) : String
	// +removeReport(reportId : String) : String

	@RequestMapping(value = "/registReport.do", method = RequestMethod.GET)//
	public ModelAndView showRegistReport(String reportType, String reportTargetId) {
// reportType, reportTargetId  도장 꾹꾹, reporterId는 jsp에서 userId로 받아버려
		
		reportType = "spot";
		reportTargetId = "3";
		
		ModelAndView modelAndView = new ModelAndView("registReport.do");
		
		modelAndView.addObject("reportTargetId", reportTargetId);
		modelAndView.addObject("reportType", reportType);
		
		return modelAndView;

	}

	@RequestMapping(value = "/registReport.do", method = RequestMethod.POST)//
	public String registReport(Report report, HttpSession session) {

		String userId = "sy";
		
		String reporterId = (String) session.getAttribute(userId);
		Integer reportTargetId = (Integer) session.getAttribute("reportTargetId");
		String reportType = (String) session.getAttribute("reportType");
		String reportContent = (String)session.getAttribute("reportContent");
		
		report.setReporterId(reporterId);
		report.setReportTargetId(reportTargetId);
		report.setReportType(reportType);
		report.setReportContents(reportContent);
		

		reportService.registRepot(report);

		return "redirect:/userPage.do?userId=" + report.getReporterId();
	}

	@RequestMapping(value = "/userReport.do")
	public ModelAndView showUserReport(HttpSession session) {//
		User user = new User();
		user.setUserId("sy");

		List<Report> userReportList = reportService.findReportsByReporterId(session.getId());

		ModelAndView modelAndView = new ModelAndView("userReport.jsp");
		modelAndView.addObject("userReportList", userReportList);

		return modelAndView;
	}

	@RequestMapping(value = "/adminReport.do")
	public ModelAndView showAdminReport() {

		List<Report> allReportList = reportService.findAllReports();

		ModelAndView modelAndView = new ModelAndView("adminReport.jsp");
		modelAndView.addObject("allReportList", allReportList);

		return modelAndView;
	}
	
	@RequestMapping(value = "/searchReportByType.do")
	public ModelAndView showSearchByReportType(String reportType) {
		
		List<Report> reportList = reportService.findReportsByReportType(reportType);
		
		ModelAndView modelAndView = new ModelAndView("adminReport.jsp");
		modelAndView.addObject("reportList", reportList);
		
		return modelAndView;
	}

	@RequestMapping(value = "/blackList.do")
	public ModelAndView showBlackList(String status) {

		List<String> blackList = reportService.findBlackList(status);

		ModelAndView modelAndView = new ModelAndView("blackList.jsp");
		modelAndView.addObject("blackList", blackList);

		return modelAndView;
	}

	
	public ModelAndView showSuspectReport(String suspectId) {

		List<Report> blakcListDetail = reportService.findReportsBySuspectId(suspectId);
		
		ModelAndView modelAndView = new ModelAndView("blackListDetail.jsp");
		modelAndView.addObject("blackListDetail", blakcListDetail);
		
		return modelAndView;
		
	}

	public ModelAndView showModifyReport(String reportId) {
		
		return null;
	}

	public String modifyReport(Report report) {
		
//		String reportTarget = "1";
//		Report r = reportService.findReport(Integer.parseInt(reportTargetId);
//		reportService.modifyReport(r);
		
		return null;
	}

	public String removeReport(String reportId) {
		return null;
	}
}
