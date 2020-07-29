<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Page</title>
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
	background-color : rgba(0,0,0,0.5);
	width : 40%;
	height :420px;
	margin-left : 30%;
	padding : 4px;
	border : 2px solid black;
	border-radius : 20px;
	box-shadow : 10px 10px 8px 10px #888888;
	font-size : 20px;
	text-align : center;
}
#sender, #receiver,#amount{
	height : 40px;
	width : 90%;
	text-align : center;
	font-size : 20px;
}

.head{
	font-size : 30px;

}
section form label {
	text-align: left;
}

#submit{
 	width : 50%;
 	margin-left :8%;
	 height : 50px;
 	background-color:green;
 	border : 2px solid black;
 	border-radius : 20px;
 	color : white;
 	font-size : 25px;
 	text-align : center;
 
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
		<h1>Transaction Processing Window</h1>
	</header>
	<br />
	<br />
<section>
	<div class = "head">Transaction Script</div>
	<hr />
	<form action = "/transaction.bnk" method = "Post">
	<label for = "sender">From: <input type = "text" name = "sender" id = "sender" placeholder = ${userName} value = ${userName} readonly = "readonly" /></label>
	<br />
	<br />
	
	<label for = "receiver">Receiver </label>
	<select name = "receiver" id = "receiver">
	<option value = "UserName1">UserName1</option>
	<option value = "UserName2">UserName2</option>
	<option value = "UserName4">UserName4</option>
	<option value = "UserName5">UserName5</option>
	<option value = "UserName6">UserName6</option>
	
	</select>
	
	<br />
	<br />
	
	<label for = "amount">Amount: <input type = "number" name = "amount" id = "amount" placeholder = 0 min = "100" max = "5000" /></label>
	<br />
	<br />
	<input id = "submit" type = "submit"  value = "Send Money"/>
	
	</form>
</section>

<br />
<div id="error"><p>${ErrorMessage}</div>

<a href = "/userpage.bnk">Go Back to User Page</a>
</body>
</html>