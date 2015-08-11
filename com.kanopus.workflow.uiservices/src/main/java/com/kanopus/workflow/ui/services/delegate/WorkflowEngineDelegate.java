package com.kanopus.workflow.ui.services.delegate;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.kanopus.workflow.ui.services.routers.WorkflowEngineRouter;
import com.kanopus.workflow.ui.services.routers.WorkflowEngineServicesURLs;
import com.kanopus.workflow.uiservices.schemas.GetLoginInfoRequest;
import com.kanopus.workflow.uiservices.schemas.GetLoginInfoResponse;

public class WorkflowEngineDelegate {

	@Autowired
	RestTemplate restTemplate;
	
	public GetLoginInfoResponse getLoginInformation(WorkflowEngineRouter router,GetLoginInfoRequest request)
	{
		
		try
		{
			URI url = new URI(router.getAccessURI() + "/"
					+ WorkflowEngineServicesURLs.USER
					);
			//response = template.postForEntity(url, request, GetProfileInformationResponse.class).getBody();
		}catch(Exception e)
		{
			
		}
		
		GetLoginInfoResponse response = null;
		return response;
	}
	
}
