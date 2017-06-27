package com.att.pricerd.workflow.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.util.json.JSONObject;
import org.camunda.bpm.engine.runtime.ProcessInstance;

public interface BPMUtility {
	
	

	public void startEvent(String processId,Map<?, ?> variables);
	public ProcessInstance startEvent(String processId);
	
	public String getVariables(String processDefinitionKey,String variableName,String processInstanceId);

	

	

}
