package com.kanopus.workflow.ui.services.controllers;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kanopus.workflow.exceptions.WorkflowEngineConfigException;
import com.kanopus.workflow.ui.services.delegate.WorkflowEngineDelegate;
import com.kanopus.workflow.ui.services.routers.WorkflowEngineRouter;
import com.kanopus.workflow.ui.services.routers.WorkflowUIServiceURLs;
import com.kanopus.workflow.uiservices.schemas.GetLoginInfoRequest;
import com.kanopus.workflow.uiservices.schemas.GetLoginInfoResponse;

@RestController
@RequestMapping(WorkflowUIServiceURLs.baseURL)
public class WorkflowEngineLoginController {

	@Autowired
	private WorkflowEngineRouter workflowRouter;
	
	@Autowired
	private WorkflowEngineDelegate delegate;
	
	@PostConstruct
	public void verifyWorkflowEngineConfig()
	{
		try
		{
		if(workflowRouter.getAccessURI() == null)
		{
			System.out.println("Failed to get Workflow Engine config .. exiting");
			System.exit(0);
		}
		else
		{
			System.out.println("Using Workflow Engine config URL " + workflowRouter.getAccessURI());
		}
		}catch(WorkflowEngineConfigException ex)
		{
			ex.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
		   e.printStackTrace();
		   System.exit(0);
		}
	}
	
	
	@ExceptionHandler
	public String handleBadRequest(Exception ex,HttpServletRequest request)
	{
		System.out.println("*********** Incoming request : " + request);
		ex.printStackTrace();
		return "Workflow UI Services Exception : Internal Error Please check logs";
	}
	
	// Restful services below	
	@RequestMapping(value = WorkflowUIServiceURLs.getLoginInformation, method = RequestMethod.POST)
	public @ResponseBody GetLoginInfoResponse getLoginInformation(@RequestBody GetLoginInfoRequest request)
	{
		GetLoginInfoResponse response = null;
		return response;
	}
	
}
