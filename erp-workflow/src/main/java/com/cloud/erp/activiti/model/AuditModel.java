package com.cloud.erp.activiti.model;

import java.io.Serializable;

public class AuditModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * commit, amend, check
	 */
	private String taskBusinessType;

	/**
	 * none, approve, reject
	 */
	private String path;
	private Integer businessKey;
	private String businessClass;
	private String result;
	private String remark;

	public AuditModel() {
	}
	
	public AuditModel(String taskBusinessType) {
		this(taskBusinessType, "", null, "", "", "");
	}
	
	public AuditModel(String taskBusinessType, Integer businessKey, String businessClass) {
		this(taskBusinessType, "", businessKey, businessClass);
	}
	
	public AuditModel(String taskBusinessType, String path,
			Integer businessKey, String businessClass) {
		this(taskBusinessType, path, businessKey, businessClass, "", "");
	}
	
	public AuditModel(String taskBusinessType, String path,
			Integer businessKey, String businessClass, String result, String remark) {
		this.taskBusinessType = taskBusinessType;
		this.path = path;
		this.businessKey = businessKey;
		this.businessClass = businessClass;
		this.result = result;
		this.remark = remark;
	}

	public String getTaskBusinessType() {
		return taskBusinessType;
	}

	public void setTaskBusinessType(String taskBusinessType) {
		this.taskBusinessType = taskBusinessType;
	}
	
	public Integer getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(Integer businessKey) {
		this.businessKey = businessKey;
	}
	
	public String getBusinessClass() {
		return businessClass;
	}

	public void setBusinessClass(String businessClass) {
		this.businessClass = businessClass;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
