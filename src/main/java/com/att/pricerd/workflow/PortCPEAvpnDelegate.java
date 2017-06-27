package com.att.pricerd.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PortCPEAvpnDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Processing request in PortCPEAvpnDelegate '"+execution.getVariable("offer")+"'...");
	       
		//String response=DiscoveryUtil.callService("pricing.pricerd.att.com","1.0.0","LAB","LAB","/restservices/pricing/v1/service/hello","NON-PROD");
		String response="PortCPEAvpnDelegate";
	    System.out.println("value of resp PortCPEAvpnDelegate:" + response);
		execution.setVariable("PORT-CPE-AVPN-DELEGATE-RESPONSE", response); 
		
	}

}
