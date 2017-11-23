package store;

import java.util.List;

import domain.Report;

public interface ReportStore {
	
	boolean createRepot(Report report);
	List<Report> retrieveReportsByReporterId(String reporterId);
	List<Report> retrieveReportsBySuspectId(String suspectId);
	List<Report> retrieveAllReports();
	List<Report> retrieveReportsByReportType(String reportType);
	List<String> retrieveBlackList();
	Report retrieveReport(String reporterId, int targetId);
	boolean updateReport(Report report);
	boolean deleteReport(int reportId);

}
