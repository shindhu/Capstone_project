<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Login</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>

</head>
<body id="body_layout">
	<c:import url="/WEB-INF/navbar.jsp" />
	
	
	<div id="outerbody" style="border: none;" >
		<div class="col-md-4"> </div>
		
		<div class="col-md-4">
		<h3 style="text-align: left;color:blue;">Login</h3>
		<p style="color:red">${error }</p>
		<form  action="LoginServlet" method="get">
			
			<input type="hidden" name="action" value="login">
			<div class="form-group">
				<label>Username:</label> <input class="form-control"
					style="width: 300px; font-size: 20;" type="text" name="username" required placeholder="username">
			</div>
			<div class="form-group">
				<label>Password:</label> <input class="form-control"
					style="width: 300px; font-size: 20;" type="password" name="password" required placeholder="password">
			</div>
			<div class="form-group">
				<label>&nbsp;</label> <input class="btn btn-primary active"
					type="submit" value="Login" id="submit">
			</div>
		</form>
		<p>NEW USER? <a href="/LearningDiary/signup" style="color:red;">REGISTER HERE</a></p>
	</div>
	
	<div class="col-md-4"></div>
	</div>
	
	
	<div>
		<%@ include file="/WEB-INF/footer.jsp" %>
	</div>
</body>
</html>