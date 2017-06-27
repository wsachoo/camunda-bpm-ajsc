package com.att.pricerd.service.rs;


import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.att.ajsc.common.Tracable;
import com.att.pricerd.common.LogMessages;
import com.att.ajsc.common.AjscService;

import com.att.pricerd.model.HelloWorld;
import com.att.pricerd.service.SpringService;
import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;

@AjscService
public class RestServiceImpl implements RestService {	
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(RestServiceImpl.class);

	@Autowired
	private SpringService service;

	public RestServiceImpl() {
		// needed for autowiring
	}

	@Override
	@Tracable(message = "invoking quick hello")
	public HelloWorld getQuickHello(String name) {	
		log.info(LogMessages.RESTSERVICE_HELLO);
		log.debug(LogMessages.RESTSERVICE_HELLO_NAME, name);
		return service.getQuickHello(name);
	}

	@Override
	public String getSampleResponse() {
		// TODO Auto-generated method stub
		log.debug("Inside getSampleResponse");
		log.info("Inside getSampleResponse");
		return service.getSampleResponse();
	}

	@Override
	public String printProductName(String product) {
		log.debug("Inside printProductName :" + product);
		log.info("Inside printProductName : " + product);
		return product;
	}
	
	@Override
	public String getMicroserviceName(String product) {
		log.debug("Inside callMicroservice :" + product);
		log.info("Inside callMicroservice : " + product);
		return service.getMicroserviceName(product);
	}

}
