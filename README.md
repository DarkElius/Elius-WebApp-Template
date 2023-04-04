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

There are two parameters that muset be set at jvm level:
 * **ewa.path**, set the resource directory complete path
       *i.e.: -Dewa.path=/my-path-name/resources*
       

 * **log4j.configurationFile**, set the Apache Log4j2 xml complete path
       *i.e.: -Dlog4j.configurationFile=/my-path-name/resources/log4j2.xml*



### License

Apache 2.0 - <https://www.apache.org/licenses/LICENSE-2.0>


