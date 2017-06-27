package com.att.pricerd.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.RestTemplate;

public class PortAndCPEDelegate2 implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Processing request in PortAndCPEDelegate2 '"+execution.getVariable("offer")+"'...");
	       
		//String response=DiscoveryUtil.callService("pricing.pricerd.att.com","1.0.0","LAB","LAB","/restservices/pricing/v1/service/hello","NON-PROD");
/*		String response="PortAndCPEDelegate";
	    System.out.println("value of resp PortAndCPEDelegate:" + response);
		execution.setVariable("callmicroservicevariable", response);
*/		
	    RestTemplate template = new RestTemplate();
	    String strResp = template.getForObject("http://localhost:9000/", String.class);
	    execution.setVariable("callmicroservicevariable2", "{noport:" + strResp + "}"); 
	}
}
