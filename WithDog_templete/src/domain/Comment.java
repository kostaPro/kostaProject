package domain;

import java.sql.Date;
import java.util.List;

public class Comment {
	
	private int commentId;
	private String writerId;
	private String content;
	private Date registDate;
	private List<Comment> replyList;
	private int targetId;
	
	private String parentId;
	private String depth;
	
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	
	public int getTargetId() {
		return targetId;
	}
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public List<Comment> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<Comment> replyList) {
		this.replyList = replyList;
	}

}
