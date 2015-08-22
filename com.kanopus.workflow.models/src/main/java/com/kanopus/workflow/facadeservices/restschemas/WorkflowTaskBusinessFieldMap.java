package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;

public class WorkflowTaskBusinessFieldMap implements Serializable {
	

	private static final long serialVersionUID = -709440508172759776L;
	
	private int id;
	private String taskName;
	private String fieldName;
	private String fieldDatatype;
	private String fieldDefaultValue;
	
	public WorkflowTaskBusinessFieldMap() {
		super();	
	}

	public WorkflowTaskBusinessFieldMap(int id, String taskName,
			String fieldName, String fieldDatatype, String fieldDefaultValue) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.fieldName = fieldName;
		this.fieldDatatype = fieldDatatype;
		this.fieldDefaultValue = fieldDefaultValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
