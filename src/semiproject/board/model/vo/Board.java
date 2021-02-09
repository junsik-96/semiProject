package semiproject.board.model.vo;

import java.sql.Date;

public class Board {
	
	private int bdIdx;
	private String userId;
	private Date regDate;
	private String title;
	private String content;
	private int count;
	private String field;
	
	
	public int getBdIdx() {
		return bdIdx;
	}
	public void setBdIdx(int bdIdx) {
		this.bdIdx = bdIdx;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Board [bdIdx=" + bdIdx + ", userId=" + userId + ", regDate=" + regDate + ", title=" + title
				+ ", content=" + content + ", count=" + count + ", field=" + field + "]";
	}
	
	
	
	
	
}
