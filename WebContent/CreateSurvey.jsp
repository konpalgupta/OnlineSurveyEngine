<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Create Survey</title>
    <link rel = "stylesheet" type="text/css" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
</head>
<body>
    <section>
    <div class="bgPulse">
                
        <div class ="topnav">
        <a class ="active" href="#home">Home</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
        <div></div><form method="post" action="Logout"><input type="submit" name="logout" value = "Logout" style="float:right;padding: 10px 16px;"></form>
       
		
		<center>
		<h2> Survey Status! </h2>
		<% if ((request.getAttribute("display"))!=null) { %><div id="msg"><%= request.getAttribute("display") %></div><% } %>
		<button id="btn"><span>ADD QUESTION</span></button>
		</center>
		
		<!-- The Modal -->
		<div id="myModal" class="modal">
		
		  	<!-- Modal content -->
		    <div class="modal-content">
		    <div class="modal-header">
		    <span class="close">[x]</span>
		    <h2 style="color:white;">ADD QUESTION HERE</h2>
		    </div>
		  	<div class="form">
		     <form class="login-form" method=post action="addQuestion">
		     <input type="hidden" name="sid" value="<%= request.getAttribute("jsp_sid")%>">
		      <input style="height:40px; margin-left:23%; width:50%;" type="text" name="ques_stmt" placeholder="Type question statement"/></br></br>
		      Select the type of question : <input type="radio" name="r1" value="Text" checked> Text
		      								<input type="radio" name="r1" value="Radio"> Single Choice
		      								<input type="radio" name="r1" value="Checkbox"> Multiple Choice</br></br>
		      <textarea style="height:80px; margin-left:23%; width:50%;" name="options" placeholder="In case of options, put * before every option"/></textarea></br></br>
		      <textarea style="margin-left:23%; width:50%;" name="ans" placeholder="Type your answer..."/></textarea></br></br>
		      <input type="submit" id="button2" value="SAVE QUESTION">
		      </form>
		  	</div>
		  </div>  
		</div>
		<div>

		<c:forEach items="${list_questions}"  var="rows">
	     		<h3> <c:out value="${rows.getqstmt()}"/> </h3>
     		<c:if test="${rows.getqtype()=='Radio'}">
     		<c:set var = "string1" value = "${fn:split(rows.getqoptions(), '*')}" />
	     		<c:forEach var="i" begin="0" end="${fn:length(string1)-1}">
	     		<input type="radio" name="r2"/> ${string1[i]}</br>
	  			</c:forEach>
	  		</c:if>
	  		<c:if test="${rows.getqtype()=='Checkbox'}">
     		<c:set var = "string1" value = "${fn:split(rows.getqoptions(), '*')}" />
	     		<c:forEach var="i" begin="0" end="${fn:length(string1)-1}">
	     		<input type="checkbox" name="r2"/>${string1[i]}</br>
	  			</c:forEach>
	  		</c:if>
  		</c:forEach>
		</div>
		<div>
		<form method="post" action="saveSurvey">
		<center><input type="submit" value="SAVE SURVEY"/></center>
		</form>
		</div>
		<script>
				// Get the modal
				var modal = document.getElementById('myModal');
				
				// Get the button that opens the modal
				var btn= document.getElementById("btn");
				
				
				// Get the <span> element that closes the modal
				var span = document.getElementsByClassName("close")[0];
				
				// When the user clicks the button, open the modal
				btn.onclick = function() {
				    modal.style.display = "block";
				}
				
				// When the user clicks on <span> (x), close the modal
				span.onclick = function() {
				    modal.style.display = "none";
				}
				
				// When the user clicks anywhere outside of the modal, close it
				window.onclick = function(event) {
				    if (event.target == modal) {
				        modal.style.display = "none";
				    }
				}
				
				</script>
		
    </div>            
    </section>        
</body>
</html>