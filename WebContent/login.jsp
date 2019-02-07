



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

        <script type="text/javascript" src="registeration.js"></script>
<script> 

function validation()                                    
{ 
    var email = document.forms["loginForm"]["email"];               
    var password = document.forms["loginForm"]["password"];  
  
    if (email.value == "" || password.value=="")                                  
    { 
        window.alert("Please enter all requred information"); 
        email.focus(); 
        return false; 
    } 
    else if ((password.length) < 8) {
    alert("Password should atleast 8 character in length");
    }
    else if ((email.indexOf("@", 0) < 0) || (email.indexOf(".", 0) < 0) )
    {
        alert ("please enter a valid email");
    }
    return true; 
}</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Include CSS File Here -->
<link rel="stylesheet" type="text/css" href="style.css">
<title>login</title>
</head>
<div class="header">
    <h1>Login</h1>
</div>
<body>
<div class="center">
            <form name=loginForm id="sign_up_form" action="Login" method="post" onsubmit="return validation()" >
  <p> ${message}</p>

                <div class="input-group"> 
                   
                    <label> Email</label>
                    
                    <input type="email" name="email">
                    <br/>
                    <br>
                    <label> Password </label>
                   
                    <input type="password" name="password">
                   
                    <br>
                    <input class="btn" id="submit_btn" type="submit" value="submit">
                    </div>
                    <p>
       Not yet a member? <a href="home.jsp">Register</a>
    </p>
	
                    </form>
                    </div>
</body>
</html>