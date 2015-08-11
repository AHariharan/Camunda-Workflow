package com.kanopus.workflow.ui.services.routers;

import com.kanopus.workflow.exceptions.WorkflowEngineConfigException;

public class WorkflowEngineRouter {

	private String hostname = null;
	private String portno = null ;
	private String baseURL = null;
	
	public WorkflowEngineRouter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkflowEngineRouter(String hostname, String portno, String baseURL) {
		super();
		this.hostname = hostname;
		this.portno = portno;
		this.baseURL = baseURL;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPortno() {
		return portno;
	}

	public void setPortno(String portno) {
		this.portno = portno;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}
	
	
	public String getAccessURI() throws WorkflowEngineConfigException
	{
		String URL = null;
		if(hostname == null || portno == null || baseURL == null)
			throw new WorkflowEngineConfigException("Invalid Workflow Engine config exception,  hostname = " + hostname + " , port = " + portno + " , baseURL : " + baseURL);
		else
			URL = "http://"+hostname+":"+portno+baseURL;
		return URL;
	}
	
}
