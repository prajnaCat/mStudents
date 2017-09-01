package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "task", catalog = "mstudents")
public class Task implements java.io.Serializable {

	// Fields

	private String taskId;
	private String courseId;
	private String zhuanyeId;
	private String teaId;
	private Date fabuTime;
	private Date jiezhiTime;
	private String yaoqiu;
	private String referDoc;
	private String beizhu;
	private String isvalue;
	private String teadocid;
	private String taskname;
	private String tasknameid;

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** minimal constructor */
	public Task(String taskId, String courseId, String zhuanyeId, String teaId) {
		this.taskId = taskId;
		this.courseId = courseId;
		this.zhuanyeId = zhuanyeId;
		this.teaId = teaId;
	}

	/** full constructor */
	public Task(String taskId, String courseId, String zhuanyeId, String teaId,
			Date fabuTime, Date jiezhiTime, String yaoqiu,
			String referDoc, String beizhu, String isvalue, String teadocid,
			String taskname, String tasknameid) {
		this.taskId = taskId;
		this.courseId = courseId;
		this.zhuanyeId = zhuanyeId;
		this.teaId = teaId;
		this.fabuTime = fabuTime;
		this.jiezhiTime = jiezhiTime;
		this.yaoqiu = yaoqiu;
		this.referDoc = referDoc;
		this.beizhu = beizhu;
		this.isvalue = isvalue;
		this.teadocid = teadocid;
		this.taskname = taskname;
		this.tasknameid = tasknameid;
	}

	// Property accessors
	@Id
	@Column(name = "task_id", unique = true, nullable = false, length = 32)
	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	@Column(name = "course_id", nullable = false, length = 32)
	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Column(name = "zhuanye_id", nullable = false, length = 7)
	public String getZhuanyeId() {
		return this.zhuanyeId;
	}

	public void setZhuanyeId(String zhuanyeId) {
		this.zhuanyeId = zhuanyeId;
	}

	@Column(name = "tea_id", nullable = false, length = 6)
	public String getTeaId() {
		return this.teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	@Column(name = "fabu_time", length = 19)
	public Date getFabuTime() {
		return this.fabuTime;
	}

	public void setFabuTime(Date fabuTime) {
		this.fabuTime = fabuTime;
	}

	@Column(name = "jiezhi_time", length = 19)
	public Date getJiezhiTime() {
		return this.jiezhiTime;
	}

	public void setJiezhiTime(Date jiezhiTime) {
		this.jiezhiTime = jiezhiTime;
	}

	@Column(name = "yaoqiu", length = 2000)
	public String getYaoqiu() {
		return this.yaoqiu;
	}

	public void setYaoqiu(String yaoqiu) {
		this.yaoqiu = yaoqiu;
	}

	@Column(name = "refer_doc", length = 30)
	public String getReferDoc() {
		return this.referDoc;
	}

	public void setReferDoc(String referDoc) {
		this.referDoc = referDoc;
	}

	@Column(name = "beizhu", length = 1000)
	public String getBeizhu() {
		return this.beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	@Column(name = "isvalue", length = 2)
	public String getIsvalue() {
		return this.isvalue;
	}

	public void setIsvalue(String isvalue) {
		this.isvalue = isvalue;
	}

	@Column(name = "teadocid", length = 30)
	public String getTeadocid() {
		return this.teadocid;
	}

	public void setTeadocid(String teadocid) {
		this.teadocid = teadocid;
	}

	@Column(name = "taskname", length = 50)
	public String getTaskname() {
		return this.taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	@Column(name = "tasknameid", length = 6)
	public String getTasknameid() {
		return this.tasknameid;
	}

	public void setTasknameid(String tasknameid) {
		this.tasknameid = tasknameid;
	}

}