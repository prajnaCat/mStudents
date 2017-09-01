package com.common.model;

import java.util.Date;

public class SubmitDetailVo {
	private Integer id;
	private String subId;
	private String stuId;
	private String stuName;
	private String classId;
	private Date fbtime;
	private String  titime;
	private Date jiezhiTime;
	private String tjstatus;
	private String stuDocId;
	private Integer score;
	
	private String taskname;
	
	
	private String coursename;
	private String courseid;
	
	private String docname;//生成的文档名
	private String name;//原来的文档名
	
	private String teaDocId;//作业参考文档id
	private String teadocname;//作业参考文档名
	private String teaname;//作业参考文档原名
	
	public String getTeaDocId() {
		return teaDocId;
	}
	public void setTeaDocId(String teaDocId) {
		this.teaDocId = teaDocId;
	}
	public String getTeadocname() {
		return teadocname;
	}
	public void setTeadocname(String teadocname) {
		this.teadocname = teadocname;
	}
	public String getTeaname() {
		return teaname;
	}
	public void setTeaname(String teaname) {
		this.teaname = teaname;
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
	public String  getTitime() {
		return titime;
	}
	public void setTitime(String  titime) {
		this.titime = titime;
	}
	public Date getJiezhiTime() {
		return jiezhiTime;
	}
	public void setJiezhiTime(Date jiezhiTime) {
		this.jiezhiTime = jiezhiTime;
	}
	public String getTjstatus() {
		return tjstatus;
	}
	public void setTjstatus(String tjstatus) {
		this.tjstatus = tjstatus;
	}
	public String getStuDocId() {
		return stuDocId;
	}
	public void setStuDocId(String stuDocId) {
		this.stuDocId = stuDocId;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubId() {
		return subId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public Date getFbtime() {
		return fbtime;
	}
	public void setFbtime(Date fbtime) {
		this.fbtime = fbtime;
	}
	
	
	
	
	
}
