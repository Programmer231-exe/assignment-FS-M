<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.io.*,java.util.*,java.sql.*" %>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Page</title>
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
		display : inline-block:
	}
	header h1{
	display : inline-block;
	}
	
	
#button{
 float : right ;

 height : 50px;
 color : white;
 font-size : 25px;
 margin-top: 1%;
  text-align : center;
 
}

#button a {
	margin-top : 20%;
	color : white;
	text-decoration: none;
	text-align : center;
	text-decoration : bold;
}
#button a:hover{
	font-size : 28px;
}

table{
	border-collapse : collapse;
	background-color : rgba(0,0,0,0.7);
	border : 3px solid white;
}

.balan{
	display : inline;
}
.balan:hover{
	font-size : 50px;
}

th, td{
	padding : 15px;
}

tr:hover{

	font-size : 20px;
}

#transfer_but{
 width : 50%;
 margin-left : 23%;
 height : 50px;
 background-color:green;
 border : 2px solid black;
 border-radius : 20px;
 color : white;
 font-size : 25px;
 text-align : center;
 
}

#transfer_but a {
	color : white;
	text-decoration : none;
}
#transfer_but a:hover{
	font-size : 20px;
}

</style>

</head>
<body>

<sql:setDataSource var = "dbConnection" driver = "com.mysql.jdbc.Driver"
	url = "jdbc:mysql://localhost:3306/online_transaction" 
	user = "CrazyShiva" password = "hcl" />
	
	
 	<sql:query dataSource = "${dbConnection}" var = "result">
 		SELECT * FROM transaction WHERE from_user = "${userName}" OR to_user = "${userName}" ORDER BY time_of_transaction DESC LIMIT 5;
 	</sql:query>
<header>
<h1>Online Transaction Demo</h1>
<div id="button"><a href = "/logout.bnk">Logout</a></div>
</header>
<section>
<h1> HI ${userName} </h1>
<hr />

<h2>Your account balance is Rs. <div class = "balan">${balance}</div></h2>

<h3>Your Last 5 Transaction Report is: </h3>
	<table border = "1" width = "100%">

	<tr>
		<th>Transaction_ID</th>
		<th>From</th>
		<th>To</th>
		<th>Amount</th>
		<th>Status</th>
		<th>Time</th>
		<th>Reason</th>
	</tr>
	
	<c:forEach var = "row" items= "${result.rows}" >
		<tr>
			<td><c:out value = "${row.transaction_id}" /></td>
			<td><c:out value = "${row.from_user}" /></td>
			<td><c:out value = "${row.to_user}" /></td>
			<td><c:out value = "${row.amount}" /></td>
			<td><c:out value = "${row.status}" /></td>
			<td><c:out value = "${row.time_of_transaction}" /></td>
			<td><c:out value = "${row.reason}" /></td>
		</tr>
	
	</c:forEach>
	

</table>
</section>
<br />
<br />

<div id= "transfer_but"><a href =  "/transaction.bnk">Transfer Money</a></div>


</body>
</html>