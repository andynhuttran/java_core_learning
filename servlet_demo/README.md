**What is in the project?**

1. Create Servlet project with maven
  
    1.1 Create maven project and choise *web archetype* from maven
    
    1.2 Add *javax.servlet-api* and *javax.servlet.jsp-api* to dependency [refer link](https://github.com/colenhuttran/java_core_learning/blob/master/servlet_demo/pom.xml)
    
    1.3 Config Tomcat to eclipse from Servers window.
    
2. Build sample hello Servlet

    2.1 Right click to project, then choise New -> Servlet, input package and class name, define url mapping, choise supported methods (get, post...)
    After these steps, take a look to web.xml to see new good stuff 
    [refer link](https://github.com/colenhuttran/java_core_learning/blob/master/servlet_demo/src/main/webapp/WEB-INF/web.xml).
    
    Defination about Servlet and Servlet Mapping are added into the file so that Server container can call to the Servlet when there is a request from Client or web browser.
    
    2.2 Implement **back-end** by coding body of **doGet, doPost** to process request from Client, then feedback by using response [refer link](https://github.com/colenhuttran/java_core_learning/blob/master/servlet_demo/src/main/java/com/javalearning/servlet_demo/helloServlet.java)
    
    2.3 Implement **front-end** by creating from to submit request to Server in *index.jsp* [refer link](https://github.com/colenhuttran/java_core_learning/blob/master/servlet_demo/src/main/webapp/index.jsp)
    
    2.4 Right click to project > **Run As > Run on Server**
   
3. Demo forward in Servlet

    Back-end: [refer link](https://github.com/colenhuttran/java_core_learning/blob/master/servlet_demo/src/main/java/com/javalearning/forward_redirect_demo/ForwardDemoServlet.java).
    Font-end: [refer link](https://github.com/colenhuttran/java_core_learning/blob/master/servlet_demo/src/main/webapp/index.jsp).
    
    **There is good stuff from the Demo**
    
    1. Using annotation to define Servlet by using **@WebServlet** instead of web.xml.
    2. Forward to another Servlet by using **RequestDispatcher.forward** function.
    3. Send data to another Servlet by **request.setAttribute** function.
    
    Forward means a Servlet (in the same website) send data, request, response to another Servlet to process data. **Url is NOT changed**
