<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel = "stylesheet" type="text/css" href="AdminHomeStyle.css">
<title>Admin</title>
</head>
<body>
	<div class = "topnav">
            <a class = "active" href="#home">Home</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
            <form method="post" action="Logout"><input type="submit" name="logout" value = "Logout" style="float:right;padding: 10px 16px;"></form>
            <div class ="rightInfo">Welcome <%= request.getAttribute("myname") %></div>
            
    </div>
    <center>
	<h2>Surveys</h2></br>
	<form method="post" action="createSurvey">
		SURVEY NAME: <input type="text" name="survey_name" value="" style="padding: 12px 20px; width:50%"/></br></br>
		<input type="submit" value="CREATE SURVEY"></br></br>
	</form>
	</center>
	<section>
	</br></br>
		<table>
		 <c:forEach var="survey" items="${listSurvey}">
                <tr>
                    <td><c:out value="${survey.sname}" /></td>
                    <td>
                        <a href="./edit?id=<c:out value='${survey.sid}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="./delete?id=<c:out value='${survey.sid}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
	</table>
	</section>
</body>
</html>