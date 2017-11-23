package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Report;
import domain.Review;
import service.ReportService;
import store.ReportStore;
import store.UserStore;

@Service
public class ReportServiceLogic implements ReportService{
	
	@Autowired
	private ReportStore reportStore;
	@Autowired
	private UserStore userStore;
	
	@Override
	public boolean registRepot(Report report) {
		
		return false;
	}
	@Override
	public List<Report> findReportsByReporterId(String reporterId) {
		
		return null;
	}
	@Override
	public List<Report> findReportsBySuspectId(String suspectId) {
		
		return null;
	}
	@Override
	public List<Report> findAllReports() {
		
		return null;
	}
	@Override
	public List<Report> findReportsByReportType(String reportType) {
	
		return null;
	}
	@Override
	public List<String> findBlackList() {
		
		return null;
	}
	@Override
	public Report findReport(String reporterId, int targetId) {
		
		return null;
	}
	@Override
	public boolean modifyReport(Report report) {
		
		return false;
	}
	@Override
	public boolean removeReport(int reportId) {
		
		return false;
	}


}
