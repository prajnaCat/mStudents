package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TeacherInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teacher_info", catalog = "mstudents")
public class TeacherInfo implements java.io.Serializable {

	// Fields

	private String teaId;
	private String teaName;
	private String teaPassword;
	private String teaSex;
	private String teaAge;
	private String isvalue;

	// Constructors

	/** default constructor */
	public TeacherInfo() {
	}

	/** minimal constructor */
	public TeacherInfo(String teaId, String teaName, String teaPassword) {
		this.teaId = teaId;
		this.teaName = teaName;
		this.teaPassword = teaPassword;
	}

	/** full constructor */
	public TeacherInfo(String teaId, String teaName, String teaPassword,
			String teaSex, String teaAge, String isvalue) {
		this.teaId = teaId;
		this.teaName = teaName;
		this.teaPassword = teaPassword;
		this.teaSex = teaSex;
		this.teaAge = teaAge;
		this.isvalue = isvalue;
	}

	// Property accessors
	@Id
	@Column(name = "tea_id", unique = true, nullable = false, length = 6)
	public String getTeaId() {
		return this.teaId;
	}

	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	@Column(name = "tea_name", nullable = false, length = 20)
	public String getTeaName() {
		return this.teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	@Column(name = "tea_password", nullable = false, length = 6)
	public String getTeaPassword() {
		return this.teaPassword;
	}

	public void setTeaPassword(String teaPassword) {
		this.teaPassword = teaPassword;
	}

	@Column(name = "tea_sex", length = 2)
	public String getTeaSex() {
		return this.teaSex;
	}

	public void setTeaSex(String teaSex) {
		this.teaSex = teaSex;
	}

	@Column(name = "tea_age", length = 4)
	public String getTeaAge() {
		return this.teaAge;
	}

	public void setTeaAge(String teaAge) {
		this.teaAge = teaAge;
	}

	@Column(name = "isvalue", length = 2)
	public String getIsvalue() {
		return this.isvalue;
	}

	public void setIsvalue(String isvalue) {
		this.isvalue = isvalue;
	}

}