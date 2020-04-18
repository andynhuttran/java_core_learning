Guide to config and use log4j

1. Download log4j-core.jar, log4j-api.jar, then add to class path. There are 2 ways to do this:

   1.1. First, using maven, access maven reposiorty to search the jars to get dependencies (recommend).
   
   1.2. Second, download jar file from apache web site, then put add to class path manually.
  
2. Create log4j2.xml file under scr/main/resources folder. This file cotaints configurations for log4j.
There are something we should know about log4j configuration. [here](https://github.com/colenhuttran/java_core_learning/tree/master/log4j_demo/src/main/resources)

   2.1. <Properties> define properties which could be used from order tags like path_file, log_format...
   
   2.2 <Appenders> define the way to write log to user, in this example there are two kind of log: log to console and file. We have some kind of file.
   It said that: RollingRandomAccessFile and Async could improve performance better
   
   2.3 Loggers tag contain 2 tags Logger and Root:
   
   Root: is on top, it applys for all files in project, remember to add <AppenderRef name="refer_to_appender_you_want_to_write_log">
   
   Logger: you could define packages which is apply this log, remember to add <AppenderRef name="refer_to_appender_you_want_to_write_log">
   
3. After finish configuration, take a look [here](https://github.com/colenhuttran/java_core_learning/blob/master/log4j_demo/src/main/java/com/javalearning/log4j_demo/MainDemo.java)
to know how to use log4j. there are some kind of level log like: info, error, trace, debug...
