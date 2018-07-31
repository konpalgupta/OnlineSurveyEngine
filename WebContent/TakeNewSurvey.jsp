<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
		body{
    margin: 0;
    padding: 0;
    background-color: rgb(201,233,246);
    font-family: 'Playfair Display', serif;
}

section{
    position: absolute;
    width: 100%;
    height: 100%;
    overflow: hidden;
}
.bgPulse{
    width: 100%;
    height: 100%;
}
.topnav{
    background: rgba(0,0,0,.5);
    overflow: hidden;
}
.topnav a{
    float: left;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 17px;
}
.topnav a:hover{
    background: rgba(0,0,0,.8);
    color: grey;
}
.rightInfo{
	float: right;
	color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 17px;
}
h2{
	text-align: center;
	color: rgba(0,0,0,0.5);
	font-size: 60px;
}

table{
	font-size: 25px;
	padding: 20px;
	align-self: center;	
}
tr{
	padding-top: 10px;
	padding-bottom: 10px;
}
td{
	padding-left : 30px;
	padding-right: 30px;
}
td a{
	text-decoration: none;
	color: rgba(0,0,0,0.5);
}
		</style>
</head>
<body>
	<div class = "topnav">
            <a class = "active" href="#home">Home</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
            <div class = "rightInfo">Welcome User&nbsp;&nbsp;<form action = "Logout" method = "post"> <input type="submit" name="logout" value = "logout"></form></div>
    </div>
    <div class = "surveys">
    		<h2>Surveys</h2>
    		<a href = "./UserHome.jsp" style = "float: right; padding: 10px; font-size: 25px; color: rgba(0,0,0,0.5);">View Responses</a><br><br><br><br>
    		<table>
    			<c:forEach var="survey" items="${surveyNotTaken}">
                <tr>
                    <td><c:out value="${survey.sname}" /></td>
                    <td>
                        <a href="/takeSurvey?id=<c:out value='${survey.sid}' />">Take Survey</a>                     
                    </td>
                </tr>
            </c:forEach>
    		</table>
    	</div>
</body>
</html>