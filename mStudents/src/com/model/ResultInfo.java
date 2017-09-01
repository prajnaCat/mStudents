package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ResultInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "result_info", catalog = "mstudents")
public class ResultInfo implements java.io.Serializable {

	// Fields

	private String resId;
	private String stuId;
	private String stuName;
	private String classId;
	private String courseId;
	private String coursename;
	private Date sctime;
	private Integer tasknum;
	private Integer jiaonum;
	private Integer pingfnum;
	private Double resfen;
	private Double pjscore;
	private Double maxscore;
	private Double minscore;
	private Double fangcha;
	private Double bzcha;
	private String pfstatus;
	private String isvalue;

	// Constructors

	/** default constructor */
	public ResultInfo() {
	}

	/** minimal constructor */
	public ResultInfo(String resId, String stuId, String courseId) {
		this.resId = resId;
		this.stuId = stuId;
		this.courseId = courseId;
	}

	/** full constructor */
	public ResultInfo(String resId, String stuId, String stuName,
			String classId, String courseId, String coursename,
			Date sctime, Integer tasknum, Integer jiaonum,
			Integer pingfnum, Double resfen, Double pjscore, Double maxscore,
			Double minscore, Double fangcha, Double bzcha, String pfstatus,
			String isvalue) {
		this.resId = resId;
		this.stuId = stuId;
		this.stuName = stuName;
		this.classId = classId;
		this.courseId = courseId;
		this.coursename = coursename;
		this.sctime = sctime;
		this.tasknum = tasknum;
		this.jiaonum = jiaonum;
		this.pingfnum = pingfnum;
		this.resfen = resfen;
		this.pjscore = pjscore;
		this.maxscore = maxscore;
		this.minscore = minscore;
		this.fangcha = fangcha;
		this.bzcha = bzcha;
		this.pfstatus = pfstatus;
		this.isvalue = isvalue;
	}

	// Property accessors
	@Id
	@Column(name = "res_id", unique = true, nullable = false, length = 32)
	public String getResId() {
		return this.resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	@Column(name = "stu_id", nullable = false, length = 9)
	public String getStuId() {
		return this.stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	@Column(name = "stu_name", length = 20)
	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	@Column(name = "class_id", length = 20)
	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@Column(name = "course_id", nullable = false, length = 7)
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

	@Column(name = "sctime", length = 19)
	public Date getSctime() {
		return this.sctime;
	}

	public void setSctime(Date sctime) {
		this.sctime = sctime;
	}

	@Column(name = "tasknum")
	public Integer getTasknum() {
		return this.tasknum;
	}

	public void setTasknum(Integer tasknum) {
		this.tasknum = tasknum;
	}

	@Column(name = "jiaonum")
	public Integer getJiaonum() {
		return this.jiaonum;
	}

	public void setJiaonum(Integer jiaonum) {
		this.jiaonum = jiaonum;
	}

	@Column(name = "pingfnum")
	public Integer getPingfnum() {
		return this.pingfnum;
	}

	public void setPingfnum(Integer pingfnum) {
		this.pingfnum = pingfnum;
	}

	@Column(name = "resfen")
	public Double getResfen() {
		return this.resfen;
	}

	public void setResfen(Double resfen) {
		this.resfen = resfen;
	}

	@Column(name = "pjscore")
	public Double getPjscore() {
		return this.pjscore;
	}

	public void setPjscore(Double pjscore) {
		this.pjscore = pjscore;
	}

	@Column(name = "maxscore")
	public Double getMaxscore() {
		return this.maxscore;
	}

	public void setMaxscore(Double maxscore) {
		this.maxscore = maxscore;
	}

	@Column(name = "minscore")
	public Double getMinscore() {
		return this.minscore;
	}

	public void setMinscore(Double minscore) {
		this.minscore = minscore;
	}

	@Column(name = "fangcha")
	public Double getFangcha() {
		return this.fangcha;
	}

	public void setFangcha(Double fangcha) {
		this.fangcha = fangcha;
	}

	@Column(name = "bzcha")
	public Double getBzcha() {
		return this.bzcha;
	}

	public void setBzcha(Double bzcha) {
		this.bzcha = bzcha;
	}

	@Column(name = "pfstatus", length = 4)
	public String getPfstatus() {
		return this.pfstatus;
	}

	public void setPfstatus(String pfstatus) {
		this.pfstatus = pfstatus;
	}

	@Column(name = "isvalue", length = 2)
	public String getIsvalue() {
		return this.isvalue;
	}

	public void setIsvalue(String isvalue) {
		this.isvalue = isvalue;
	}

}