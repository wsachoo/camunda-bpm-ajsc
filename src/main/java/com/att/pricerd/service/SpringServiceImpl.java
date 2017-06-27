package com.att.pricerd.service;

import org.camunda.bpm.engine.runtime.ProcessInstance;
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
}