package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import domain.Report;
import service.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;
	
//	+showRegistReport(reportType : String, targetId : String) : ModelAndView
//	+registReport(report : Report, session : HttpSession) : String
//	+showUserReport(session : HttpSession) : ModelAndView
//	+showAdminReport() : ModelAndView
//	+showSearchByReportType(reportType : String) : ModelAndView
//	+showBlackList() : ModelAndView
//	+showSuspectReport(suspectId : String) : ModelAndView
//	+showModifyReport(reportId : String) : ModelAndView
//	+modifyReport(report : Report) : String
//	+removeReport(reportId : String) : String
	
	public ModelAndView showRegistReport(String rerportType, String reportTargetId) {
		return null;
	}
	
	public String registReport(Report report, HttpSession session) {
		return null;
	}
	
	public ModelAndView showUserReport(HttpSession session) {
		return null;
	}
	
	public ModelAndView showAdminReport() {
		return null;
	}
	
	public ModelAndView showSearchByReportType(String reportType) {
		return null;
	}
	
	public ModelAndView showBlackList(String status) {
		return null;
	}
	
	public ModelAndView showSuspectReport(String suspectId) {
		return null;
	}
	
	public ModelAndView showModifyReport(String reportId) {
		return null;
	}
	
	public String modifyReport(Report report) {
		return null;
	}

	public String removeReport(String reportId) {
		return null;
	}
}

