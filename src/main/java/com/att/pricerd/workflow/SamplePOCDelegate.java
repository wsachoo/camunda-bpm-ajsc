package com.att.pricerd.workflow;


import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SamplePOCDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		    System.out.println("Processing request in CPE SamplePOCDelegate");
		  
		    Map<String, String> response = new HashMap<String, String>();
		   	//String response=DiscoveryUtil.callService("pricing.pricerd.att.com","1.0.0","LAB","LAB","/restservices/pricing/v1/service/hello","NON-PROD");
		   	//System.out.println("value of resp:" + response);
		    RestTemplate template = new RestTemplate();
		    String strResp = template.getForObject("http://localhost:8000/", String.class);
		    response.put("port", strResp);
		    
		  // String response="SamplePOCResponse";
		    ObjectMapper mapper = new ObjectMapper();
		    
		    System.out.println("Message read from URL is: " + mapper.writeValueAsString(response));
		    
		   
		    //System.out.println("value of resp:" + response);
		   	execution.setVariable("samplepocvariable", "{port:" + strResp + "}"); 
		   	
	}
	
}
