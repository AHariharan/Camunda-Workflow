package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;

public class WorkflowStartSendMap implements Serializable {
	
	private static final long serialVersionUID = -7777338485378199256L;
	
	private int variableId;
	private String variableName;
	private String variableDatatype;
	private String varAdditionalObjecttypename;
	private String varSerializationDataformat;
	private int parentVarId;
	
	private Boolean isMandatory;	
	private Boolean isStart;
	private Boolean isSendMessage;
	
	
	public WorkflowStartSendMap() {
		super();
	}


	public WorkflowStartSendMap(int variableId, String variableName,
			String variableDatatype, String varAdditionalObjecttypename,
			String varSerializationDataformat, int parentVarId,
			Boolean isMandatory, Boolean isStart, Boolean isSendMessage) {
		super();
		this.variableId = variableId;
		this.variableName = variableName;
		this.variableDatatype = variableDatatype;
		this.varAdditionalObjecttypename = varAdditionalObjecttypename;
		this.varSerializationDataformat = varSerializationDataformat;
		this.parentVarId = parentVarId;
		this.isMandatory = isMandatory;
		this.isStart = isStart;
		this.isSendMessage = isSendMessage;
	}


	public int getVariableId() {
		return variableId;
	}


	public void setVariableId(int variableId) {
		this.variableId = variableId;
	}


	public String getVariableName() {
		return variableName;
	}


	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}


	public String getVariableDatatype() {
		return variableDatatype;
	}


	public void setVariableDatatype(String variableDatatype) {
		this.variableDatatype = variableDatatype;
	}


	public String getVarAdditionalObjecttypename() {
		return varAdditionalObjecttypename;
	}


	public void setVarAdditionalObjecttypename(String varAdditionalObjecttypename) {
		this.varAdditionalObjecttypename = varAdditionalObjecttypename;
	}


	public String getVarSerializationDataformat() {
		return varSerializationDataformat;
	}


	public void setVarSerializationDataformat(String varSerializationDataformat) {
		this.varSerializationDataformat = varSerializationDataformat;
	}


	public int getParentVarId() {
		return parentVarId;
	}


	public void setParentVarId(int parentVarId) {
		this.parentVarId = parentVarId;
	}


	public Boolean getIsMandatory() {
		return isMandatory;
	}


	public void setIsMandatory(Boolean isMandatory) {
		this.isMandatory = isMandatory;
	}


	public Boolean getIsStart() {
		return isStart;
	}


	public void setIsStart(Boolean isStart) {
		this.isStart = isStart;
	}


	public Boolean getIsSendMessage() {
		return isSendMessage;
	}


	public void setIsSendMessage(Boolean isSendMessage) {
		this.isSendMessage = isSendMessage;
	}
	
	
}
