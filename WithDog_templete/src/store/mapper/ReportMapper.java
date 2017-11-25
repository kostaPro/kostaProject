package store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import domain.Report;

public interface ReportMapper {
	
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
	
	boolean deleteEventCommentReport(int reportId);
	boolean deleteMeetingCommentReport(int reportId);
	boolean deleteMeetingReport(int reportId);
	boolean deleteReviewCommentReport(int reportId);
	boolean deleteReviewReport(int reportId);
	boolean deleteSpotReport(int reportId);

	List<Report> retrieveReportsByReporterId(String reporterId);
	List<Report> retrieveReportsBySuspectId(String suspectId);
	List<Report> retrieveAllReports();
	List<Report> retrieveReportsByReportType(Map<String, String> map);
	List<String> retrieveBlackList();
	Report retrieveReport(@Param("reportType") String reportType, @Param("reportTargetId") int reportTargetId );
	
}
