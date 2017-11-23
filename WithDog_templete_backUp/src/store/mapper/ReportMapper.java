package store.mapper;

import java.util.List;
import java.util.Map;

import domain.Report;

public interface ReportMapper {
	
	boolean createRepot(Report report);
	
	List<Report> retrieveReportsByReporterId(String reporterId);
	List<Report> retrieveReportsBySuspectId(String suspectId);
	
	List<Report> retrieveAllReports();
	
	List<Report> retrieveReportsByReportType(String reportType);
	List<String> retrieveBlackList();
	
	Report retrieveReport(Map<String,Object> map);
	
	boolean updateReport(Report report);
	
	boolean deleteReport(int reportId);
}
