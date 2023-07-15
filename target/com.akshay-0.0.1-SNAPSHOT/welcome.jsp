<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home page</title>
<style>
.image1{
margin-right:60px}
.value2{
margin-right:70px}
.value{
margin-right:70px}
.value1{
margin-right:43px}
.image1,.image{
display:inline-block;
vertical-align:middle;}
.value1,.quantity{
display:inline-block;
vertical-align:middle;}
.value2,.size{
display:inline-block;
vertical-align:middle;}
.value,.title{
display:inline-block;
vertical-align:middle;}
.enter{
margin-left:50px;}
.element{
position:absolute;
top:0;
right:0;}
body{
margin-top:10px;
margin-right:10px;}
</style>
</head>
<body>
<%

	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

	response.setHeader("Pragma","no-cache");
	
	response.setHeader("Expires","0");
	if(session.getAttribute("username")==null){
		response.sendRedirect("login.jsp");
	}
%>
Welcome ${username}
<form action="Logout">
<input type="submit" value="Logout" class ="element">
</form><h1><center>
<p>Product Management Tool</p></center></h1><br><br>
<div class="enter">
<h3><p>Please Enter Product details to add to stock</p></h3>
<form action ="AddData" >
<div class="continer">
 <p class="value">Title</p><input type="text" name="title"><br>
 <p class="value1">Quantity</p><input type="text" name="quantity"><br>
 <p class="value2">Size</p><input type="text" name="size"><br>
 <p class="image1">Image</p><input type="text" name="image"><br>
 </div><br><br>
 <input type="submit" value="browse">
</form>
</div>
<%@ page import="com.welcome.dao.DatabaseReader" %>
<%
DatabaseReader dr =  new DatabaseReader();


%>
<table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Quantity</th>
            <th>Size</th>
            <th>Image</th>
        </tr>
        <c:forEach items="${dataList}" var="data">
            <tr>
                <td>${data[0]}</td>
                <td>${data[1]}</td>
                <td>${data[2]}</td>
                <td>${data[3]}</td>
                <td>${data[4]}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
</body>
</html>