<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
.registerBox{
    position: relative;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    width: 500px;
    height: 610px;
    box-sizing: border-box;
    background: rgba(0,0,0,.5);
    padding-left: 40px;
    padding-right: 40px;
    padding-top: 40px;
    padding-bottom: 40px;
    border-color: rgba(0,0,0,0.2);
    border-style: inset;
    
}

.registerBox h2{
	font-size: 40px;
    margin: 0;
    padding-bottom: 10px;
    color: rgba(0,0,0,.5);
    text-align: center;
}
.registerBox p{
    margin: 0;
    padding: 0;
    font-weight: bold;
    color: #fff;
}
.registerBox input{
    width: 100%;
    margin-bottom: 20px;
}
input[type = "text"], input[type = "email"],input[type = "password"],input[type = "date"]{
    border: none;
    border-bottom: 1px solid #fff;
    background: transparent;
    outline: none;
    height: 40px;
    color: #fff;
    font-size: 16px;
}
::placeholder{
    color: rgba(255,255,255,.5);
}
input[type="submit"]{
    border: none;
    outline: none;
    height: 40px;
    color: #fff;
    font-size: 16px;
    background: rgba(0,0,0,.5);
    cursor: pointer;
    border-radius: 20px;
}
input[type="submit"]:hover{
    border: none;
    outline: none;
    height: 40px;
    color: rgba(0,0,0,.5);
    font-size: 16px;
    background: #fff;
    cursor: pointer;
    border-radius: 20px;
}
.loginBox a{
    font-size: 14px;
    color: #fff;
    font-weight: bold;
    text-decoration: none;
    text-align: center;
    
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
    font-size: 18px;
}
#title{
    float: left;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 18px;
}
.topnav a:hover{
    background: rgba(0,0,0,.8);
    color: white;
}
body{
    margin: 0;
    padding: 0;
}
section{
    position: absolute;
    width: 100%;
    overflow: hidden;
    height: 100%;
}
.pulse{
    width: 100%;
    height: 100%;
}
.pulse span{
    position: absolute;
    width: 60px;
    height: 60px;
    background: #fff;
}
.pulse span:nth-child(3n+1){
    border: 5px solid #fff;
    background: transparent;
}
.pulse span:nth-child(1){
    top: 10% ;
    left: 20%;
    animation: animate 10s linear infinite;
}
.pulse span:nth-child(2){
    top: 85% ;
    left: 10%;
    animation: animate 15s linear infinite;
}
.pulse span:nth-child(3){
    top: 20% ;
    left: 90%;
    animation: animate 8s linear infinite;
}
.pulse span:nth-child(4){
    top: 50% ;
    left: 60%;
    animation: animate 10s linear infinite;
}
.pulse span:nth-child(5){
    top: 40% ;
    left: 30%;
    animation: animate 6s linear infinite;
}
.pulse span:nth-child(6){
    top: 30% ;
    left: 75%;
    animation: animate 18s linear infinite;
}
.pulse span:nth-child(7){
    top: 90% ;
    left: 90%;
    animation: animate 14s linear infinite;
}
.pulse span:nth-child(8){
    top: 40% ;
    left: 10%;
    animation: animate 5s linear infinite;
}
.pulse span:nth-child(9){
    top: 80% ;
    left: 70%;
    animation: animate 8s linear infinite;
}
.pulse span:nth-child(10){
    top: 50% ;
    left: 50%;
    animation: animate 6s linear infinite;
}
@keyframes animate{
    0%{
        transform: scale(0) translateY(0) rotate(0deg);
        opacity: 1;
    }
    100%{
        transform: scale(1) translateY(-100px) rotate(360deg);
        opacity: 0;
    }
}

</style>
<script type="text/javascript">
	function validate(){
		var fname = document.register.fname;
		var lname = document.register.lname;
		var email = document.register.email;
		var pass = document.register.pass;
		var dob = document.register.dob;
		var city = document.register.city;
		if(fname.value==""||lname.value==""||email.value==""||pass.value==""||dob.value==""||city.value==""){
			alert("All fields are necessary");
			return false;
		}
		else
			return true;
	}
</script>
</head>
 <body>
        <section>
            
                <div class="pulse">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div>
            </section>
            <section>
                <div class = "topnav">
            <div id = "title">Online Survey Engine</div>
            <a href="./login.jsp" style="float: right">Login</a>
        </div>
                <div class = "registerBox">
        <h2>Register Here</h2>
        <table id = "registerTable" align = "center" width="400px">
        	<form name = "register" action="Register">
	        	<tr>
	        		<td><p>First Name</p></td>
	        		<td><input type="text" name="fname" required></td>
	        	</tr>
	        	<tr>
	        		<td><p>Last Name</p></td>
	        		<td><input type="text" name="lname"></td>
	        	</tr>
	        	<tr>
	        		<td><p>Email</p></td>
	        		<td><input type="email" name="email" required></td>
	        	</tr>
	        	<tr>
	        		<td><p>Password</p></td>
	        		<td><input type="password" name="pass" required></td>
	        	</tr>
	        	<tr>
	        		<td><p>Date Of Birth</p></td>
	        		<td><input type="Date" name="dob" required></td>
	        	</tr>
	        	<tr>
	        		<td><p>Gender</p></td>
	        		<td>
	        			<select name="gender">
	        				<option>--------</option>
	        				<option>Male</option>
	        				<option>Female</option>
	        			</select>
              		</td>
	        	</tr>
	        	<tr>
	        		<td><p>City</p></td>
	        		<td><input type="text" name="city" required></td>
	        	</tr>
	        	<tr>
	        	<td colspan="2">
	        	 <input type="submit" id = "registerUser" value="Register">
	        	 </td>
	        	 </tr>
        	</form>
        </table>
       
        
    </div>
                   </section> 
               
    </body>
</html>