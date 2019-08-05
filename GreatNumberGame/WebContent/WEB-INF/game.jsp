<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Great Number Game</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id ="container">
<h1>Welcome to the Great Number Game!</h1>
<h2>I'm thinking of a number between 1 and 100.</h2>
<h3>Take a guess!</h3>
<%String userResponse = (String) session.getAttribute("response");%>
<%!public String response(Integer response){
	return response.toString();
}%>
<%if(userResponse == "correct"){%>
<div class="correct"><h1><%=response(Integer.parseInt(request.getParameter("attempt")))%> was the answer!</h1>
<form action="Home" method="get">
<input type="submit" value="Play again?">
</form>
</div>
<%}
else {
if (userResponse == "Too low"){%>
<div class="box"><h1>Too low!</h1></div>
<%}
if(userResponse == "Too high"){%>
<div class="box"><h1>Too high!</h1></div>
<%}%>
<form action="/GreatNumberGame/GreatNumber" method="post">
<input type="number" name="attempt">
<input type="submit" value="Try">
</form>
<%}%>
</div>
</body>
</html>