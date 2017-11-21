package domain;

import java.sql.Date;
import java.util.List;

public class Review {
	
	private int reviewId;
	private String title;
	private String content;
	private List<String> reviewImageList;
	private String writerId;
	private Date registDate;
	private List<Comment> commentList;
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getReviewImageList() {
		return reviewImageList;
	}
	public void setReviewImageList(List<String> reviewImageList) {
		this.reviewImageList = reviewImageList;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

}
