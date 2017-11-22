package store;

import java.util.List;

import domain.Report;

public interface ReportStore {
	
	boolean createEventCommentReport(Report report);
	boolean createMeetingCommentReport(Report report);
	boolean createMeeingReport(Report report);
	boolean createReviewCommentReport(Report report);
	boolean createReviewReport(Report report);
	boolean createSpotReport(Report report);
	
	boolean updateEventCommentReport(Report report);
	boolean updateMeetingCommentReport(Report report);
	boolean updateMeeingReport(Report report);
	boolean updateReviewCommentReport(Report report);
	boolean updateReviewReport(Report report);
	boolean updateSpotReport(Report report);
	
	boolean deleteEventCommentReport(int reportId);
	boolean deleteMeetingCommentReport(int reportId);
	boolean deleteMeeingReport(int reportId);
	boolean deleteReviewCommentReport(int reportId);
	boolean deleteReviewReport(int reportId);
	boolean deleteSpotReport(int reportId);

	List<Report> retrieveReportsByReporterId(String reporterId);
	List<Report> retrieveReportsBySuspectId(String suspectId);
	List<Report> retrieveAllReports();
	List<Report> retrieveReportsByReportType(String reportType);
	List<String> retrieveBlackList();
	Report retrieveReport(String reporterId, int targetId);
	
}
