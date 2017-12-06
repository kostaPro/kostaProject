package service;

import java.util.List;
import java.util.Map;

import domain.Report;
import domain.BlackList;

public interface ReportService {

	boolean registReport(Report report);
	List<Report> findReportsByReporterId(String reporterId);
	List<Report> findReportsBySuspectId(String suspectId);
	List<Report> findAllReports();
	List<Report> findReportsByReportType(String reportType);
	List<BlackList> findBlackList();
	Report findReport(int reportTargetId);
	boolean modifyReport(Report report);
	boolean removeReport(int reportTargetId);
	
}
