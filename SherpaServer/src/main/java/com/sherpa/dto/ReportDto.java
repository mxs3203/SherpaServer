package com.sherpa.dto;

import com.sherpa.model.Event;
import com.sherpa.model.Report;
import com.sherpa.model.User;
import com.sherpa.util.Util;

public class ReportDto {

	private long reportId;
	private long eventId;
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
		return eventId;
	}

	public void setEvent(long eventId) {
		this.eventId = eventId;
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

	public Report toModel() {
		Report report = new Report();

		report.setReportId(reportId);

		Event event = new Event(eventId);
		report.setEvent(event);

		User user = new User(userByUserId);
		report.setUserBySherpaId(user);

		User sherpa = new User(userBySherpaId);
		report.setUserBySherpaId(sherpa);

		report.setDate(Util.getDateJoda(date));
		report.setComment(comment);

		return report;
	}

}
