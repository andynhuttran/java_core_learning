<html>
<body>

<h2>Hello Servlet and JSP</h2>

<hr /> Demo call Servlet by Get <br />
<form action="helloServletUrl" method="get">
	Enter your name here: <input type="text" name="txtName" /> <br/>
	<input type="submit" value="Call Servlet by Get" />
</form>

<hr /> Demo call Servlet by Post <br />
<form action="helloServletUrl" method="post">
	Enter your name here: <input type="text" name="txtName" /> <br/>
	<input type="submit" value="Call Servlet by Post" />
</form>


<hr /> Demo call Servlet and Forward <br />
<form action="forwardDemo" method="get">
	Do you want to use forward? <br /> 
	
	<input type="radio" id="yes" name="forward" value="yes"/>
	<label for="yes">Yes</label><br>
	
	<input type="radio" id="no"  name="forward" value="no"/>
	<label for="no">No</label><br>
	
	<input type="submit" value="Call Servlet and Forward" />
</form>


</body>
</html>
