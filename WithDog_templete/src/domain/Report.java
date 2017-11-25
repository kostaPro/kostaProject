package domain;

public class Report {
	
	private String reportContent;
	private String reportType;
	private int reportTargetId;
	private String reporterId;
	private String status;
	
	public String getReportContents() {
		return reportContent;
	}
	public void setReportContents(String reportContent) {
		this.reportContent = reportContent;
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

}
