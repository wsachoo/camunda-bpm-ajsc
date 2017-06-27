package com.att.pricerd.workflow.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.history.HistoricVariableInstance;
import org.camunda.bpm.engine.impl.util.json.JSONObject;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.att.aft.dme2.internal.gson.JsonObject;

public class BPMUtilityImpl implements BPMUtility {

	
	
	@Override
	public  void startEvent(String processId, Map variables) {
		
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();		
	  	 
		processEngine.getRuntimeService().startProcessInstanceByKey(processId,variables);
		
		
	}
	@Override
	public  ProcessInstance startEvent(String processId) {
		
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();		
	  	 
		return processEngine.getRuntimeService().startProcessInstanceByKey(processId);
		
		
	}
	
	@Override
	public String getVariables(String processDefinitionKey,String variableName,String processInstanceId) {
		// TODO Auto-generated method stub
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();	
		
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		HistoryService historyService=processEngine.getHistoryService();
		
		//ProcessInstance processInstance = runtimeService
			    //  .createProcessInstanceQuery()
			      //.processInstanceBusinessKey(processDefinitionKey)
			      //.singleResult();
		
		//HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(processDefinitionKey).singleResult();
		
		List processInstances=historyService.createHistoricProcessInstanceQuery().list();
		historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).list();
		
		//List<HistoricVariableInstance> variables = processEngine.getHistoryService().createHistoricVariableInstanceQuery().variableName("response").list();

		List<HistoricVariableInstance> variables = processEngine.getHistoryService().createHistoricVariableInstanceQuery().processInstanceId(processInstanceId).variableName(variableName).list();
		//return variables;
		List values=new ArrayList();
		variables.forEach(x -> values.add(x.getValue()));
		return (String)values.get(0);
		
	}


	

}
