package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * StuDocInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "stu_doc_info", catalog = "mstudents")
public class StuDocInfo implements java.io.Serializable {

	// Fields

	private String studocid;
	private String submitId;
	private String docname;
	private String isvalue;
	private String name;

	// Constructors

	/** default constructor */
	public StuDocInfo() {
	}

	/** minimal constructor */
	public StuDocInfo(String studocid) {
		this.studocid = studocid;
	}

	/** full constructor */
	public StuDocInfo(String studocid, String submitId, String docname,
			String isvalue, String name) {
		this.studocid = studocid;
		this.submitId = submitId;
		this.docname = docname;
		this.isvalue = isvalue;
		this.name = name;
	}

	// Property accessors
	@Id
	@Column(name = "studocid", unique = true, nullable = false, length = 20)
	public String getStudocid() {
		return this.studocid;
	}

	public void setStudocid(String studocid) {
		this.studocid = studocid;
	}

	@Column(name = "submit_id", length = 32)
	public String getSubmitId() {
		return this.submitId;
	}

	public void setSubmitId(String submitId) {
		this.submitId = submitId;
	}

	@Column(name = "docname", length = 20)
	public String getDocname() {
		return this.docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	@Column(name = "isvalue", length = 2)
	public String getIsvalue() {
		return this.isvalue;
	}

	public void setIsvalue(String isvalue) {
		this.isvalue = isvalue;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}