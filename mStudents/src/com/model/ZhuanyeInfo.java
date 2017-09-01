package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ZhuanyeInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "zhuanye_info", catalog = "mstudents")
public class ZhuanyeInfo implements java.io.Serializable {

	// Fields

	private String zhuanyeId;
	private String zhuanyeName;
	private String yuanxi;
	private String isvalue;

	// Constructors

	/** default constructor */
	public ZhuanyeInfo() {
	}

	/** minimal constructor */
	public ZhuanyeInfo(String zhuanyeId) {
		this.zhuanyeId = zhuanyeId;
	}

	/** full constructor */
	public ZhuanyeInfo(String zhuanyeId, String zhuanyeName, String yuanxi,
			String isvalue) {
		this.zhuanyeId = zhuanyeId;
		this.zhuanyeName = zhuanyeName;
		this.yuanxi = yuanxi;
		this.isvalue = isvalue;
	}

	// Property accessors
	@Id
	@Column(name = "zhuanye_id", unique = true, nullable = false, length = 7)
	public String getZhuanyeId() {
		return this.zhuanyeId;
	}

	public void setZhuanyeId(String zhuanyeId) {
		this.zhuanyeId = zhuanyeId;
	}

	@Column(name = "zhuanye_name", length = 30)
	public String getZhuanyeName() {
		return this.zhuanyeName;
	}

	public void setZhuanyeName(String zhuanyeName) {
		this.zhuanyeName = zhuanyeName;
	}

	@Column(name = "yuanxi", length = 30)
	public String getYuanxi() {
		return this.yuanxi;
	}

	public void setYuanxi(String yuanxi) {
		this.yuanxi = yuanxi;
	}

	@Column(name = "isvalue", length = 2)
	public String getIsvalue() {
		return this.isvalue;
	}

	public void setIsvalue(String isvalue) {
		this.isvalue = isvalue;
	}

}