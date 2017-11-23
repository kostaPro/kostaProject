package service;

import java.util.List;

import domain.Report;

public interface ReportService {

	boolean registRepot(Report report);
	List<Report> findReportsByReporterId(String reporterId);
	List<Report> findReportsBySuspectId(String suspectId);
	List<Report> findAllReports();
	List<Report> findReportsByReportType(String reportType);
	List<String> findBlackList();
	Report findReport(String reporterId, int targetId);
	boolean modifyReport(Report report);
	boolean removeReport(int reportId);
	
}
