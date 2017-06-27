
package com.att.pricerd.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PortSachDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		System.out.println("Processing request in PortSachDelegate '" + execution.getVariable("offer") + "'...");

		execution.setVariable("sachinVariable", "{sachMsg: 'Hello Sachin!'}");
	}
}
