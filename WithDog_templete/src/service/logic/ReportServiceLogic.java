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
public class ReportServiceLogic implements ReportService {

	@Autowired
	private ReportStore reportStore;
	@Autowired
	private UserStore userStore;

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
		} else{
			return reportStore.createReviewCommentReport(report);
		}
		
	}

	@Override
	public List<Report> findReportsByReporterId(String reporterId) {//

		return reportStore.retrieveReportsByReporterId(reporterId);
	}

	@Override
	public List<Report> findReportsBySuspectId(String suspectId) {

		return null;
	}

	@Override
	public List<Report> findAllReports() {

		return reportStore.retrieveAllReports();
	}

	@Override
	public List<Report> findReportsByReportType(String reportType) {

		return null;
	}

	@Override
	public List<String> findBlackList(String status) {

		return reportStore.retrieveBlackList(status);
	}

	@Override
	public Report findReport(int reportTargetId) {

		return null;
	}

	@Override
	public boolean modifyReport(Report report) {

		return false;
	}

	@Override
	public boolean removeReport(int reportTargetId) {

		return false;
	}

}
