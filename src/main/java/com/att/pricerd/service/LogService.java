package com.att.pricerd.service;

public interface LogService {   
   
    public String logMessage(String logMessageText, String javamail, String springmail, String commonsmail);
        
    public String postLogMessage(String  histEventList);

    public String createLogMessage(String startTime, String endTime, String serviceName);
    
    public String createLogMessageUsingHistory(String procInstId, String  histEventList);
    
    public String CreateHistLog(String procInstId);
    

}
