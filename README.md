Elius WebApp Template
-----



Description
-----
This project is an example where I show how to use the Elius WebApp Framework.

I use it as starting point for all my web applications.




Components
-----
When the project is compiled it'll generate a **war** file

The **resources** directory can be placed every where in your file system.

It contains:
 * **ewa.properties**, the framework properties file
 
 
 * **log4j2.xml**, the Apache Log4j2 log configuration file
 
 
 * **template.properties**, the application properties file




Compilation
-----
To compile this project you need to compile and install the Elius WebApp Framework on your local Maven repository.

When the Elius WebApp Framework will be stable it'll be released on official Maven repository.




Run
-----
This project must be deployed in an application server: I'm currently using Apache Tomcat 10.0.6.


**Parameters**

There are two parameters that muset be set at jvm level:
 * **ewa.path**, set the resource directory complete path
       *i.e.: -Dewa.path=/my-path-name/resources*
       

 * **log4j.configurationFile**, set the Apache Log4j2 xml complete path
       *i.e.: -Dlog4j.configurationFile=/my-path-name/resources/log4j2.xml*



**Database connection configuration**

This an example of the jdni resource configuration for a in memory database using Apache Derby.

*<Resource driverClassName="org.apache.derby.iapi.jdbc.AutoloadedDriver"*

 *maxIdle="2" maxTotal="10" maxWaitMillis="5"*
  
 *name="jdbc/ewadb"*
  
 *type="javax.sql.DataSource"*
  
 *url="jdbc:derby:memory:ewadb;create=true"*
  
 *username="" password=""*

*/>*




API
-----
Below some exmaple about http calls: remember to modify web.xml and your packages in case of changes.

**General**

* Add an object to database
  
  *curl -X POST -d '{"name": "foo"}' http://localhost:8080/EliusWebAppTemplate/api/ewa/object/add  --header "Content-Type:application/json"*

* Get all objects from database

  *curl http://localhost:8080/EliusWebAppTemplate/api/ewa/object/all*


**Authentications**

Execute calls in the same session

* Login

  *curl -X POST -d '{"userId": "myuser", "password": "mypassword"}' http://localhost:8080/EliusWebAppTemplate/api/auth/login --header "Content-Type:application/json"*

* Login, get logged user info

  *curl http://localhost:8080/EliusWebAppTemplate/api/auth/get*

* Logout

  *curl http://localhost:8080/EliusWebAppTemplate/api/auth/logout*


### License

Apache 2.0 - <https://www.apache.org/licenses/LICENSE-2.0>


