package com.att.pricerd.service;

import java.util.Map;

import com.att.pricerd.model.HelloWorld;

public interface SpringService {
	public HelloWorld getQuickHello(String name);
	
	public String getSampleResponse();
	
	public String getMicroserviceName(String offer);
}

