package com.common.model;

import java.util.Date;

public class ResultDetailVo {
	private String resId;
	private String stuId;
	private String stuName;
	private String classId;
	private String courseId;
	private String coursename;
	
	private Integer tasknum;
	private Integer jiaonum;
	private Integer pingfnum;
	private Double resfen;
	private Double pjscore;
	private Double maxscore;
	private Double minscore;
	private Double fangcha;
	private String pfstatus;//评分状态："11"：未评分      "22":已评分
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public Integer getTasknum() {
		return tasknum;
	}
	public void setTasknum(Integer tasknum) {
		this.tasknum = tasknum;
	}
	public Integer getJiaonum() {
		return jiaonum;
	}
	public void setJiaonum(Integer jiaonum) {
		this.jiaonum = jiaonum;
	}
	public Integer getPingfnum() {
		return pingfnum;
	}
	public void setPingfnum(Integer pingfnum) {
		this.pingfnum = pingfnum;
	}

	public Double getPjscore() {
		return pjscore;
	}
	public void setPjscore(Double pjscore) {
		this.pjscore = pjscore;
	}
	public Double getMaxscore() {
		return maxscore;
	}
	public void setMaxscore(Double maxscore) {
		this.maxscore = maxscore;
	}
	public Double getMinscore() {
		return minscore;
	}
	public void setMinscore(Double minscore) {
		this.minscore = minscore;
	}
	public Double getFangcha() {
		return fangcha;
	}
	public void setFangcha(Double fangcha) {
		this.fangcha = fangcha;
	}
	public String getPfstatus() {
		return pfstatus;
	}
	public void setPfstatus(String pfstatus) {
		this.pfstatus = pfstatus;
	}
	public Double getResfen() {
		return resfen;
	}
	public void setResfen(Double resfen) {
		this.resfen = resfen;
	}

	
	

}
