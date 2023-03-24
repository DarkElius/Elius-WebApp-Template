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


package elius.webapp.template.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import elius.webapp.template.TemplateAttributes;
import elius.webapp.framework.db.DBManager;
import elius.webapp.framework.properties.PropertiesManager;

public class DBTables {
	// Get Logger
	private static Logger logger = LogManager.getLogger(DBTables.class);

	// Properties file
	private PropertiesManager appProperties;
	
	// Database interface
	private DBManager db;
	
	// Drop table TRANSFERS
	private static final String SQL_TABLE_OBJECT_DROP = "DROP TABLE OBJECT";

	// Create table TRANSFERS
	private static final String SQL_TABLE_OBJECT = "CREATE TABLE OBJECT ("
													+ "  ID CHAR(36) NOT NULL DEFAULT ' '"
													+ ", NAME VARCHAR(1024) NOT NULL DEFAULT ''"
													+ ", PRIMARY KEY (ID))";
	
	// Datasource name
	private String datasourceName;
	
	
	/**
	 * Constructor
	 */
	public DBTables() {
		// Application properties
		appProperties = new PropertiesManager();
	}
	
	
	/**
	 * Initialize objects database
	 * @return 0 Successfully initialized, 1 Error
	 */
	public int init() {
		// Log initialization 
		logger.debug("Database initialization");
		
		// Load default properties
		if(0 != appProperties.load(TemplateAttributes.TEMPLATE_PROPERTIES_FILE)) {
			// Return error
			return 1;
		}
					
		// Load database information
		datasourceName = appProperties.get(TemplateAttributes.PROP_DATABASE_APPNAME_DATASOURCE_NAME);

		// Initialize DBManager
		db = new DBManager(datasourceName);
		
		// Queue, Drop
		if (0 != db.execute(SQL_TABLE_OBJECT_DROP)) {
			// Log action
			logger.warn("Table OBJECT doesn't exist");
		} else {
			// Log action
			logger.debug("Table OBJECT dropped");
		}

		// Queue, Create
		if (0 != db.execute(SQL_TABLE_OBJECT)) return 1;
		logger.debug("Table OBJECT created");
		
		// Set return code
		return  0;
	}

}
