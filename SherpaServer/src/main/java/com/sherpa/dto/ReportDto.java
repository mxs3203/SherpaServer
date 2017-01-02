package com.sherpa.dto;

import org.joda.time.DateTime;

public class ReportDto {

	private long reportId;
	private long event;
	private long userByUserId;
	private long userBySherpaId;
	private DateTime date;
	private String comment;
	
	
	
	public ReportDto(long reportId, long event, long userByUserId, long userBySherpaId, DateTime date, String comment) {
		this.reportId = reportId;
		this.event = event;
		this.userByUserId = userByUserId;
		this.userBySherpaId = userBySherpaId;
		this.date = date;
		this.comment = comment;
	}
	public long getReportId() {
		return reportId;
	}
	public void setReportId(long reportId) {
		this.reportId = reportId;
	}
	public long getEvent() {
		return event;
	}
	public void setEvent(long event) {
		this.event = event;
	}
	public long getUserByUserId() {
		return userByUserId;
	}
	public void setUserByUserId(long userByUserId) {
		this.userByUserId = userByUserId;
	}
	public long getUserBySherpaId() {
		return userBySherpaId;
	}
	public void setUserBySherpaId(long userBySherpaId) {
		this.userBySherpaId = userBySherpaId;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
