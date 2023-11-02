package com.socialmedia.SocialMediaAPI.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="report")
public class Report {
	@Id
	@GeneratedValue
	private String reportID;
	
	private String content;
	private int typeReport; //1: Người dùng, 2: Bài viết, 3: Báo lỗi
	private String idTarget;
	
	@ManyToOne
	@JoinColumn(name="userReportID")
	private User userReport;

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(String reportID, String content, int typeReport, String idTarget, User userReport) {
		super();
		this.reportID = reportID;
		this.content = content;
		this.typeReport = typeReport;
		this.idTarget = idTarget;
		this.userReport = userReport;
	}

	public String getReportID() {
		return reportID;
	}

	public void setReportID(String reportID) {
		this.reportID = reportID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTypeReport() {
		return typeReport;
	}

	public void setTypeReport(int typeReport) {
		this.typeReport = typeReport;
	}

	public String getIdTarget() {
		return idTarget;
	}

	public void setIdTarget(String idTarget) {
		this.idTarget = idTarget;
	}

	public User getUserReport() {
		return userReport;
	}

	public void setUserReport(User userReport) {
		this.userReport = userReport;
	}
	
	
}
