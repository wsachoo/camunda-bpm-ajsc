package com.att.pricerd.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PortAndCPEDelegateCombiner implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Into combineer");
		String callmicroservicevariable1 = (String) execution.getVariable("callmicroservicevariable1");
		System.out.println("Into combiner callmicroservicevariable1: " + callmicroservicevariable1);
		
		String callmicroservicevariable2 = (String) execution.getVariable("callmicroservicevariable2");
		System.out.println("Into combiner callmicroservicevariable2: " + callmicroservicevariable2);
		
		String sachinVariable = (String) execution.getVariable("sachinVariable");
		
		
		execution.setVariable("callmicroservicevariable",
				callmicroservicevariable1 + "\n\n" + callmicroservicevariable2 + "\n\n" + sachinVariable);
	}
}
