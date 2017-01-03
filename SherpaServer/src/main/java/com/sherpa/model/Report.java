package com.sherpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.sherpa.dto.ReportDto;
import com.sherpa.util.Util;

@Entity
@Table(name = "report", catalog = "sherpa")
public class Report implements java.io.Serializable {

	private static final long serialVersionUID = 8011271407857062629L;

	private long reportId;
	private Event event;
	private User userByUserId;
	private User userBySherpaId;
	private DateTime date;
	private String comment;

	public Report() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "report_id", unique = true, nullable = false)
	public long getReportId() {
		return this.reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id")
	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUserByUserId() {
		return this.userByUserId;
	}

	public void setUserByUserId(User userByUserId) {
		this.userByUserId = userByUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sherpa_id", nullable = false)
	public User getUserBySherpaId() {
		return this.userBySherpaId;
	}

	public void setUserBySherpaId(User userBySherpaId) {
		this.userBySherpaId = userBySherpaId;
	}

	@Column(name = "date", nullable = false, length = 19)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	public DateTime getDate() {
		return this.date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	@Column(name = "comment", nullable = false, length = 512)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/* TODO! */
	public ReportDto toDto() {
		ReportDto reportDto = new ReportDto();

		reportDto.setReportId(reportId);

		/*
		 * reportDto.setEvent(event.getEventId());
		 * reportDto.setUserByUserId(userByUserId.getUserId());
		 * reportDto.setUserBySherpaId(userBySherpaId.getUserId());
		 */

		reportDto.setDate(Util.getDateString(date));
		reportDto.setComment(comment);

		return reportDto;
	}

}
