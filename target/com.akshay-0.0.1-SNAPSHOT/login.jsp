<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment - 7</title>
<style>
form{
margin-top:15%;
text-align:center;

}
#uname,#pass{
margin-bottom:20px;
width:200px;}
</style>
</head>
<body>
<center><nav><h2>Welcome to Ecommerce website</h2></nav></center>
<form action ="Login" method="post">
Enter Username: <Input type="text" name="uname" id="uname"><br>
Enter Password: <input type="password" name="pass" id="pass"><br>
<input type="submit" value="login">
</form>
</body>
</html>