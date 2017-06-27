package com.att.pricerd.service;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.ajsc.common.Tracable;
import com.att.pricerd.common.LogMessages;

import com.att.pricerd.model.HelloWorld;
import com.att.pricerd.workflow.util.BPMUtility;
import com.att.pricerd.workflow.util.BPMUtilityImpl;
import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;

@Service
public class SpringServiceImpl implements SpringService {
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(SpringServiceImpl.class);

	public SpringServiceImpl() {
		// needed for instantiation
	}

	@Override
	@Tracable(message = "invoking quick hello service ")
	public HelloWorld getQuickHello(String name) {		

		BPMUtility bpm=new BPMUtilityImpl();
		
		ProcessInstance processInstance=bpm.startEvent("design");	
		
		String response1=bpm.getVariables("design","CPE-RESPONSE",processInstance.getId()); 
				
		String response2=bpm.getVariables("design","PORT-RESPONSE",processInstance.getId()); 
		
		
		HelloWorld hello=new HelloWorld(response1+response2);		   
	
		return hello;
		/**
		HelloWorld hello=new HelloWorld("Hello");
		
		return hello;
		**/
	}

	@Override
	public String getSampleResponse() {
		log.info("getSampleResponse");
		log.debug("getSampleResponse");
		BPMUtility bpm=new BPMUtilityImpl();
		ProcessInstance processInstance=bpm.startEvent("samplepoc");
		String response1 = bpm.getVariables("samplepoc","samplepocvariable",processInstance.getId()); 
		return response1;
		
	}
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Override
	public String getMicroserviceName(String offer) {
		log.info("getSampleResponse");
		log.debug("getSampleResponse");
		Map<String, Object> offerMap = new HashMap<String, Object>();
		offerMap.put("offer", offer);
		BPMUtility bpm=new BPMUtilityImpl();
		ProcessInstance processInstance=bpm.startEvent("call-microservice", offerMap);
		
		
		//ProcessInstance pi = runtimeService.startProcessInstanceByKey("forkJoin");
	/*	TaskQuery query = taskService.createTaskQuery()
		                         .processInstanceId(pi.getId())
		                         .orderByTaskName()
		                         .asc();

		List<Task> tasks = query.list();
		assertEquals(2, tasks.size());

		Task task1 = tasks.get(0);
		assertEquals("Receive Payment", task1.getName());
		Task task2 = tasks.get(1);
		assertEquals("Ship Order", task2.getName());*/
		
		String response1 = bpm.getVariables("call-microservice","callmicroservicevariable",processInstance.getId()); 
		return response1;
	}
}