package service.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Report;
import domain.Review;
import domain.BlackList;
import service.ReportService;
import store.ReportStore;
import store.UserStore;

@Service
public class ReportServiceLogic implements ReportService {

	@Autowired
	private ReportStore reportStore;

	@Override
	public boolean registReport(Report report) {

		String reportType = "spot";

		if (reportType == "spot") {
			return reportStore.createSpotReport(report);
		} else if (reportType == "meeting") {
			return reportStore.createMeetingCommentReport(report);
		} else if (reportType == "review") {
			return reportStore.createReviewReport(report);
		} else if (reportType == "eventComment") {
			return reportStore.createEventCommentReport(report);
		} else if (reportType == "meetingComment") {
			return reportStore.createMeetingCommentReport(report);
		} else {
			return reportStore.createReviewCommentReport(report);
		}

	}

	@Override
	public List<Report> findReportsByReporterId(String reporterId) {

		return reportStore.retrieveReportsByReporterId(reporterId);
	}

	@Override
	public List<Report> findReportsBySuspectId(String suspectId) {

		return reportStore.retrieveReportsBySuspectId(suspectId);
	}

	@Override
	public List<Report> findAllReports() {

		return reportStore.retrieveAllReports();
	}

	@Override
	public List<Report> findReportsByReportType(String reportType) {

		return reportStore.retrieveReportsByReportType(reportType);
	}

	@Override
	public List<BlackList> findBlackList() {

		return reportStore.retrieveBlackList();
	}

	@Override
	public Report findReport(int reportTargetId) {

		return reportStore.retrieveReport(reportTargetId);
	}

	@Override
	public boolean modifyReport(Report report) {

		String reportType = "spot";

		if (reportType == "spot") {
			return reportStore.updateSpotReport(report);
		} else if (reportType == "meeting") {
			return reportStore.updateMeetingCommentReport(report);
		} else if (reportType == "review") {
			return reportStore.updateReviewReport(report);
		} else if (reportType == "eventComment") {
			return reportStore.updateEventCommentReport(report);
		} else if (reportType == "meetingComment") {
			return reportStore.updateMeetingCommentReport(report);
		} else {
			return reportStore.updateReviewCommentReport(report);
		}

	}

	@Override
	public boolean removeReport(int reportTargetId) {

		return false;
	}

}
