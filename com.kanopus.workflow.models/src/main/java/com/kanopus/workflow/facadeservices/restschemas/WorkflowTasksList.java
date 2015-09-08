package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;

public class WorkflowTasksList implements Serializable {

	private static final long serialVersionUID = -2713763996332866289L;
	
	private String taskName;
	private String fieldName;
	private String fieldDatatype;
	private String fieldDefaultValue;
	
	public WorkflowTasksList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkflowTasksList(String taskName, String fieldName,
			String fieldDatatype, String fieldDefaultValue) {
		super();
		this.taskName = taskName;
		this.fieldName = fieldName;
		this.fieldDatatype = fieldDatatype;
		this.fieldDefaultValue = fieldDefaultValue;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldDatatype() {
		return fieldDatatype;
	}

	public void setFieldDatatype(String fieldDatatype) {
		this.fieldDatatype = fieldDatatype;
	}

	public String getFieldDefaultValue() {
		return fieldDefaultValue;
	}

	public void setFieldDefaultValue(String fieldDefaultValue) {
		this.fieldDefaultValue = fieldDefaultValue;
	}
	

}
