package com.kanopus.workflow.facadeservices.restschemas;

import java.io.Serializable;

public class WorkflowStartSendList implements Serializable {

	private static final long serialVersionUID = -1921182440221970080L;
	
	private int variableId;
	private String variableName;
	private String variableDatatype;
	private String varAdditionalObjtypename;
	private String varSerializationDataformat;
	private int parentVarId;
	private boolean isMandatory;
	private boolean isStart;
	private boolean isSendMessage;
	
	public WorkflowStartSendList() {
		super();
	}

	public WorkflowStartSendList(int variableId, String variableName, String variableDatatype,
			String varAdditionalObjtypename, String varSerializationDataformat,
			int parentVarId, boolean isMandatory, boolean isStart,
			boolean isSendMessage) {
		super();
		this.variableId = variableId;
		this.variableName = variableName;
		this.variableDatatype = variableDatatype;
		this.varAdditionalObjtypename = varAdditionalObjtypename;
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

	public String getVarAdditionalObjtypename() {
		return varAdditionalObjtypename;
	}

	public void setVarAdditionalObjtypename(String varAdditionalObjtypename) {
		this.varAdditionalObjtypename = varAdditionalObjtypename;
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

	public boolean isMandatory() {
		return isMandatory;
	}

	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	public boolean isSendMessage() {
		return isSendMessage;
	}

	public void setSendMessage(boolean isSendMessage) {
		this.isSendMessage = isSendMessage;
	}
	
	
	
	

}
