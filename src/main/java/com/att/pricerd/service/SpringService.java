package com.att.pricerd.service;

import com.att.pricerd.model.HelloWorld;

public interface SpringService {
	public HelloWorld getQuickHello(String name);
	
	public String getSampleResponse();
}
