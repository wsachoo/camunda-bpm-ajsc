package com.att.pricerd.common;

import com.att.eelf.i18n.EELFResolvableErrorEnum;
import com.att.eelf.i18n.EELFResourceManager;

public enum LogMessages implements EELFResolvableErrorEnum {

	RESTSERVICE_HELLO, RESTSERVICE_HELLO_NAME, SPRINSERVICE_HELLO, SPRINSERVICE_HELLO_NAME, SPRINSERVICE_HELLO_MESSAGE, SPRINSERVICE_HELLO_MESSAGE_NAME 
	,RESTLOGSERVICE_HELLO, RESTLOGSERVICE_HELLO_NAME, LOGSERVICE_HELLO_MESSAGE
	,LOGSERVICE_EMAIL_ERROR, LOGSERVICE_EMAIL_CLASS, LOGSERVICE_EMAIL_CLASS_NULL, PROCESS_INSTANCE_ID;

	static {

		EELFResourceManager.loadMessageBundle("logmessages");

	}

}
