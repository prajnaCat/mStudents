package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CourseInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "course_info", catalog = "mstudents")
public class CourseInfo implements java.io.Serializable {

	// Fields

	private String courseId;
	private String teaId;
	private String name;
	private String type;
	private Integer courseHour;
	private Date beginTime;
	private Date endTime;
	private Integer xuefen;
	private String isvalue;

	// Constructors

	/** default constructor */
	public CourseInfo() {
	}

	/** minimal constructor */
	public CourseInfo(String courseId) {
		this.courseId = courseId;
	}

	/** full constructor */
	public CourseInfo(String courseId, String teaId, String name, String type,
			Integer courseHour, Date beginTime, Date endTime,
			Integer xuefen, String isvalue) {
		this.courseId = courseId;
		this.teaId = teaId;
		this.name = name;
		this.type = type;
		this.courseHour = courseHour;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.xuefen = xuefen;
		this.isvalue = isvalue;
	}

	// Property accessors
	@Id
	@Column(name = "course_id", unique = true, nullable = false, length = 32)
	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Column(name = "tea_id", length = 6)
	public String getTeaId() {
		return this.teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type", length = 6)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "course_hour")
	public Integer getCourseHour() {
		return this.courseHour;
	}

	public void setCourseHour(Integer courseHour) {
		this.courseHour = courseHour;
	}

	@Column(name = "begin_time", length = 19)
	public Date getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "end_time", length = 19)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "xuefen")
	public Integer getXuefen() {
		return this.xuefen;
	}

	public void setXuefen(Integer xuefen) {
		this.xuefen = xuefen;
	}

	@Column(name = "isvalue", length = 2)
	public String getIsvalue() {
		return this.isvalue;
	}

	public void setIsvalue(String isvalue) {
		this.isvalue = isvalue;
	}

}