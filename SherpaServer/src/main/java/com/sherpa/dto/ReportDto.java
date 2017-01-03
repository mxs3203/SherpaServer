package com.sherpa.dto;

import com.sherpa.model.Report;

public class ReportDto {

	private long reportId;
	private long event;
	private long userByUserId;
	private long userBySherpaId;
	private String date;
	private String comment;

	public ReportDto() {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/* TODO! */
	public Report toModel() {
		Report report = new Report();
		return report;
	}

}
