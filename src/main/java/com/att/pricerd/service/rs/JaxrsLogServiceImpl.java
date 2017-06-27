package com.att.pricerd.service.rs;

import org.springframework.beans.factory.annotation.Autowired;

import com.att.pricerd.service.LogService;
import com.att.ajsc.common.AjscService;
import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;


/**
 * Service to invoke example Camunda process.
 * 
 * Try testing by using:
 * http://[hostname]:[serverPort]/services/log/log-message/your-message-here
 * 
 * @author jp931e
 *
 */
@AjscService
public class JaxrsLogServiceImpl implements JaxrsLogService {
	
	private static EELFLogger logger = AjscEelfManager.getInstance().getLogger(JaxrsLogServiceImpl.class);
	
	@Autowired
	private LogService logService;
	    
    /**
     * REST service that executes example camunda process to log input message.
     * 
     * @param logMessageText
     * @return output from service - comment on what was done
     */   
    public String logMessage(String logMessageText, String javamail, String springmail, String commonsmail) {
    	return logService.logMessage(logMessageText, javamail, springmail, commonsmail);    	
    }
     
    
    /**
     * REST service that executes example camunda process to log input message.
     * 
     * @return output from service - comment on what was done
     */
    public String postLogMessage(String  histEventList) {
    	return logService.postLogMessage(histEventList);
    }

    /**
     * REST service that executes example camunda process to log input message.
     * 
     * @param logMessageText
     * @return output from service - comment on what was done
     */    
    public String createLogMessage(String startTime, String endTime, String serviceName) {
    	return logService.createLogMessage(startTime, endTime, serviceName);
    }
    
    /**
     * REST service that executes example camunda process to log input message.
     * 
     * @param logMessageText
     * @return output from service - comment on what was done
     */   
    public String createLogMessageUsingHistory(String procInstId, String  histEventList) {
    	return logService.createLogMessageUsingHistory(procInstId, histEventList);
    }
    
    /**
     * REST service that executes example camunda process to log input message.
     * 
     * @param logMessageText
     * @return output from service - comment on what was done
     */    
    public String CreateHistLog(String procInstId) {
    	return logService.CreateHistLog(procInstId);
    }    
    
}