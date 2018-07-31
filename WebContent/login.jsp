<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Login</title>
        <link rel = "stylesheet" type="text/css" href="loginStyle.css">
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
            <a href="./index.jsp" style="float: right">Register</a>
        </div>
        
                <div class = "loginBox">
                
                    <h2>Log In Here</h2>
                    <form action = "Login" method = "post">
                        <p>Email</p>
                        <input type="email" name="email" placeholder="Enter Email">
                        <p>Password</p>
                        <input type="password" name="pass" placeholder=".......">
                        <input type="submit" value="Sign In">
                        
                        <a href = "index.jsp" style = "font-style: italic;" ><p align = "center">New User?</p></a>
                    </form>
                </div>
                           
        </section>        
    </body>

</html>