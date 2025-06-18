/**
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at
    
      http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.
*/


package elius.webapp.template;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import elius.webapp.template.db.DBTables;
import elius.webapp.framework.properties.PropertiesManager;
import elius.webapp.framework.properties.PropertiesManagerFactory;

public class TemplateService {
	
	// Get logger
	private static Logger logger = LogManager.getLogger(TemplateService.class);

	// Properties file
	private PropertiesManager appProperties;
	
	// Initialization status
	private boolean initialized;

	
	/**
	 * Initialize application
	 */
	public void initialization() {
		// Log initialization
		logger.debug("Template service initialization");
		
		// Set initial value
		initialized = true;
		
		// Application properties
		appProperties = PropertiesManagerFactory.getInstance(TemplateAttributes.TEMPLATE_PROPERTIES_FILE);
		
		// Initialize database (drop/create) if required
		if("Y".equalsIgnoreCase(appProperties.get(TemplateAttributes.PROP_DATABASE_INIT_ON_BOOT))) {
			
			// Log request received
			logger.debug("Database initialization request received");
			
			// Application database instance
			DBTables db = new DBTables();
			
			// Database Initialization
			if (0 != db.init()) {
				// Log error
				logger.error("Error during database initialization");
				// Change initialization status
				initialized = false;
			} else {
				// Log successful
				logger.info("Database initialized");			
			}
		}
		
		// Log initialization
		if(initialized)
			logger.info("Template service initialized");
		else
			logger.error("Template was not correctly initialized");
	}
	
	
	/**
	 * Destroy application
	 */
	public void destroy() {
		// Log shutdown
		logger.debug("Template shutdown");


        
		// Log shutdown
		logger.info("Template terminated");		
	}
}
