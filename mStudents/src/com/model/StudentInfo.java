package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * StudentInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student_info", catalog = "mstudents")
public class StudentInfo implements java.io.Serializable {

	// Fields

	private String stuId;
	private String stuName;
	private String stuPassword;
	private String stuSex;
	private String classId;
	private String isvalue;
	private String zhuanyeId;

	// Constructors

	/** default constructor */
	public StudentInfo() {
	}

	/** minimal constructor */
	public StudentInfo(String stuName, String stuPassword, String classId,
			String zhuanyeId) {
		this.stuName = stuName;
		this.stuPassword = stuPassword;
		this.classId = classId;
		this.zhuanyeId = zhuanyeId;
	}

	/** full constructor */
	public StudentInfo(String stuName, String stuPassword, String stuSex,
			String classId, String isvalue, String zhuanyeId) {
		this.stuName = stuName;
		this.stuPassword = stuPassword;
		this.stuSex = stuSex;
		this.classId = classId;
		this.isvalue = isvalue;
		this.zhuanyeId = zhuanyeId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "stu_id", unique = true, nullable = false, length = 10)
	public String getStuId() {
		return this.stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	@Column(name = "stu_name", nullable = false, length = 20)
	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	@Column(name = "stu_password", nullable = false, length = 6)
	public String getStuPassword() {
		return this.stuPassword;
	}

	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}

	@Column(name = "stu_sex", length = 1)
	public String getStuSex() {
		return this.stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	@Column(name = "class_id", nullable = false, length = 20)
	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@Column(name = "isvalue", length = 2)
	public String getIsvalue() {
		return this.isvalue;
	}

	public void setIsvalue(String isvalue) {
		this.isvalue = isvalue;
	}

	@Column(name = "zhuanye_id", nullable = false, length = 7)
	public String getZhuanyeId() {
		return this.zhuanyeId;
	}

	public void setZhuanyeId(String zhuanyeId) {
		this.zhuanyeId = zhuanyeId;
	}

}