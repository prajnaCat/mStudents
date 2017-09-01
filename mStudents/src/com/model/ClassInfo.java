package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ClassInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "class_info", catalog = "mstudents")
public class ClassInfo implements java.io.Serializable {

	// Fields

	private String classId;
	private String zhuanyeId;
	private Integer classNum;
	private String isvalue;

	// Constructors

	/** default constructor */
	public ClassInfo() {
	}

	/** minimal constructor */
	public ClassInfo(String classId, String zhuanyeId) {
		this.classId = classId;
		this.zhuanyeId = zhuanyeId;
	}

	/** full constructor */
	public ClassInfo(String classId, String zhuanyeId, Integer classNum,
			String isvalue) {
		this.classId = classId;
		this.zhuanyeId = zhuanyeId;
		this.classNum = classNum;
		this.isvalue = isvalue;
	}

	// Property accessors
	@Id
	@Column(name = "class_id", unique = true, nullable = false, length = 7)
	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@Column(name = "zhuanye_id", nullable = false, length = 7)
	public String getZhuanyeId() {
		return this.zhuanyeId;
	}

	public void setZhuanyeId(String zhuanyeId) {
		this.zhuanyeId = zhuanyeId;
	}

	@Column(name = "class_num")
	public Integer getClassNum() {
		return this.classNum;
	}

	public void setClassNum(Integer classNum) {
		this.classNum = classNum;
	}

	@Column(name = "isvalue", length = 2)
	public String getIsvalue() {
		return this.isvalue;
	}

	public void setIsvalue(String isvalue) {
		this.isvalue = isvalue;
	}

}