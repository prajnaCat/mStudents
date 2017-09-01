package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TeaDocInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tea_doc_info", catalog = "mstudents")
public class TeaDocInfo implements java.io.Serializable {

	// Fields

	private String teadocid;
	private String taskId;
	private String docname;
	private String isvalue;
	private String name;

	// Constructors

	/** default constructor */
	public TeaDocInfo() {
	}

	/** minimal constructor */
	public TeaDocInfo(String teadocid, String taskId) {
		this.teadocid = teadocid;
		this.taskId = taskId;
	}

	/** full constructor */
	public TeaDocInfo(String teadocid, String taskId, String docname,
			String isvalue, String name) {
		this.teadocid = teadocid;
		this.taskId = taskId;
		this.docname = docname;
		this.isvalue = isvalue;
		this.name = name;
	}

	// Property accessors
	@Id
	@Column(name = "teadocid", unique = true, nullable = false, length = 20)
	public String getTeadocid() {
		return this.teadocid;
	}

	public void setTeadocid(String teadocid) {
		this.teadocid = teadocid;
	}

	@Column(name = "task_id", length = 32)
	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
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