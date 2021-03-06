package store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import domain.Report;
import domain.BlackList;

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
	
	boolean deleteEventCommentReport(int reportTargetId);
	boolean deleteMeetingCommentReport(int reportTargetId);
	boolean deleteMeetingReport(int reportTargetId);
	boolean deleteReviewCommentReport(int reportTargetId);
	boolean deleteReviewReport(int reportTargetId);
	boolean deleteSpotReport(int reportTargetId);

	List<Report> retrieveReportsByReporterId(String reporterId);
	List<Report> retrieveReportsBySuspectId(String suspectId);
	List<Report> retrieveAllReports();
	List<Report> retrieveReportsByReportType(Map<String, String> map);
	List<BlackList> retrieveBlackList();
	
	Report retrieveReport(@Param("reportTargetId") int reportTargetId);
	
}
