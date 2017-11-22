package domain;

public class Report {
	
	private String reportContents;
	private String reportType;
	private int reportTargetId;
	private String reporterId;
	private String suspectId;
	private String status;
	
	public String getReportContents() {
		return reportContents;
	}
	public void setReportContents(String reportContents) {
		this.reportContents = reportContents;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public int getReportTargetId() {
		return reportTargetId;
	}
	public void setReportTargetId(int reportTargetId) {
		this.reportTargetId = reportTargetId;
	}
	public String getReporterId() {
		return reporterId;
	}
	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSuspectId() {
		return suspectId;
	}
	public void setSuspectId(String suspectId) {
		this.suspectId = suspectId;
	}
	

}
