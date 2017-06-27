/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.att.pricerd.workflow;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
public class CPEDelegate implements JavaDelegate {

  private static final Logger LOGGER = LoggerFactory.getLogger(CPEDelegate.class);

  //@Override
  public void execute(DelegateExecution execution) throws Exception {
	  
	  
    System.out.println("Processing request in CPE Delegate'"+execution.getVariable("port_id")+"'...");
  
    
   	//String response=DiscoveryUtil.callService("pricing.pricerd.att.com","1.0.0","LAB","LAB","/restservices/pricing/v1/service/hello","NON-PROD");
   	//System.out.println("value of resp:" + response);
    
    String response="Response1";
    System.out.println("value of resp:" + response);
   	execution.setVariable("CPE-RESPONSE",response); 
  
  }

}
