<%@ page language="java" contentType="text/html; charset=utf - 8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
<style>

body{
background-color : rgba(0,0,0,0.2);
font-family : verdana;
color : white;

}

header {
width : 100 %;
background-color : grey;
color : white;
border-radius : 20px;
padding : 15px;
text-align : center;
}

section{
	background-color :#77DD77;
	width : 40%;
	height : 350px;
	margin-left : 30%;
	padding : 4px;
	border : 2px solid black;
	border-radius : 20px;
	box-shadow : 10px 10px 8px 10px #888888;
	text-align : center;
}

form{
margin-left : 2%;
text-align : left;
padding : 2px;
font-size : 20px;
}
#username, #password{
	height : 40px;
	width : 90%;
	text-align : center;
	font-size : 20px;
}

.head{
	font-size : 30px;

}

#button{
 width : 50%;
 margin-left : 23%;
 height : 50px;
 background-color:green;
 border : 2px solid black;
 border-radius : 20px;
 color : white;
 font-size : 25px;
 
}

#button:hover{
 background-color:white;
 color: black;
}

footer{
	width : 100%;
	bottom : 0;
	position : fixed;
	font-size : 25px;
	
}

footer p{
text-align : center;}

footer:hover{
	font-size : 30px;
}
#error{
	font-size : 20px;
	text-align : center;
	color : red;
}

</style>
</head>
<body>
	<header>
		<h1>Online Transaction Demo</h1>
	</header>
	<br />
	<br />
	
	<section>
		<div class = "head">Login Details</div>
		<hr />
		<form action = "/homepage.bank" method= "POST">
			<label for = "username">Username : <input type = "text" name = "username" id = "username" placeholder = "Username" required = "required"/></label>
			<br />
			<br />
			<label for = "username">Password : <input type = "password" name = "password" id = "password" placeholder = "password" required = "required"/></label>
			<br />
			<br />
			<input id = "button" type = "submit" value = "Login">
		</form>
	</section>
	<br />
	<div id="error"><p>${Error}</div>
	
	<footer>
		<p>Online Transaction Demo By Sivasankar S</p>
	</footer>

</body>
</html>