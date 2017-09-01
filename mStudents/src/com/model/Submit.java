package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Submit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "submit", catalog = "mstudents")
public class Submit implements java.io.Serializable {

	// Fields

	private String submitId;
	private String stuId;
	private String taskId;
	private String stuDocId;
	private Date pftime;
	private Date tjtime;
	private Integer score;
	private String beizhu;
	private String tjstatus;
	private String isvalue;
	private String classId;
	private String courseId;
	private String coursename;
	private String taskname;

	// Constructors

	/** default constructor */
	public Submit() {
	}

	/** minimal constructor */
	public Submit(String submitId, String stuId, String taskId,
			String tjstatus, String classId, String courseId) {
		this.submitId = submitId;
		this.stuId = stuId;
		this.taskId = taskId;
		this.tjstatus = tjstatus;
		this.classId = classId;
		this.courseId = courseId;
	}

	/** full constructor */
	public Submit(String submitId, String stuId, String taskId,
			String stuDocId, Date pftime, Date tjtime, Integer score, String beizhu,
			String tjstatus, String isvalue, String classId, String courseId,
			String coursename, String taskname) {
		this.submitId = submitId;
		this.stuId = stuId;
		this.taskId = taskId;
		this.stuDocId = stuDocId;
		this.pftime=pftime;
		this.tjtime = tjtime;
		this.score = score;
		this.beizhu = beizhu;
		this.tjstatus = tjstatus;
		this.isvalue = isvalue;
		this.classId = classId;
		this.courseId = courseId;
		this.coursename = coursename;
		this.taskname = taskname;
	}

	// Property accessors
	@Id
	@Column(name = "submit_id", unique = true, nullable = false, length = 32)
	public String getSubmitId() {
		return this.submitId;
	}

	public void setSubmitId(String submitId) {
		this.submitId = submitId;
	}

	@Column(name = "stu_id", nullable = false, length = 9)
	public String getStuId() {
		return this.stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	@Column(name = "task_id", nullable = false, length = 32)
	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	@Column(name = "stu_doc_id", length = 32)
	public String getStuDocId() {
		return this.stuDocId;
	}

	public void setStuDocId(String stuDocId) {
		this.stuDocId = stuDocId;
	}

	@Column(name = "pftime", length = 19)
	public Date getPftime() {
		return pftime;
	}

	public void setPftime(Date pftime) {
		this.pftime = pftime;
	}

	@Column(name = "tjtime", length = 19)
	public Date getTjtime() {
		return this.tjtime;
	}

	public void setTjtime(Date tjtime) {
		this.tjtime = tjtime;
	}

	@Column(name = "score")
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "beizhu", length = 1000)
	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	@Column(name = "tjstatus", nullable = false, length = 2)
	public String getTjstatus() {
		return this.tjstatus;
	}

	public void setTjstatus(String tjstatus) {
		this.tjstatus = tjstatus;
	}

	@Column(name = "isvalue", length = 2)
	public String getIsvalue() {
		return this.isvalue;
	}

	public void setIsvalue(String isvalue) {
		this.isvalue = isvalue;
	}

	@Column(name = "class_id", nullable = false, length = 20)
	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@Column(name = "course_id", nullable = false, length = 32)
	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Column(name = "coursename", length = 50)
	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	@Column(name = "taskname", length = 50)
	public String getTaskname() {
		return this.taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}


}