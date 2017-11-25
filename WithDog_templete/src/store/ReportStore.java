package store;

import java.util.List;

import domain.Report;

public interface ReportStore {
	
	boolean createEventCommentReport(Report report);
	boolean createMeetingCommentReport(Report report);
	boolean createMeetingReport(Report report);
	boolean createReviewCommentReport(Report report);
	boolean createReviewReport(Report report);
	boolean createSpotReport(Report report);
	
	boolean updateEventCommentReport(Report report);
	boolean updateMeetingCommentReport(Report report);
	boolean updateMeetingReport(Report report);
	boolean updateReviewCommentReport(Report report);
	boolean updateReviewReport(Report report);
	boolean updateSpotReport(Report report);
	
	boolean deleteEventCommentReport(int reportTargetId);
	boolean deleteMeetingCommentReport(int reportTargetId);
	boolean deleteMeetingReport(int reportTargetId);
	boolean deleteReviewCommentReport(int reportTargetId);
	boolean deleteReviewReport(int reportTargetId);
	boolean deleteSpotReport(int reportTargetId);

	List<Report> retrieveReportsByReporterId(String reporterId);
	List<Report> retrieveReportsBySuspectId(String suspectId);
	List<Report> retrieveAllReports();
	List<Report> retrieveReportsByReportType(String reportType);
	List<String> retrieveBlackList();
	Report retrieveReport(String reportType, int reportTargetId);

}
