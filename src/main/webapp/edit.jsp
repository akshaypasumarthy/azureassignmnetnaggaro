<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
margin-right:10px;}</style>
</head>
<body>
<%
String title = request.getParameter("title");
String quantity = request.getParameter("quantity");
String size = request.getParameter("size");
String image = request.getParameter("image");

%>
<h1>Edit the product</h1>
<form action="Edit" method="post">
<div class="continer">
 <p class="value">Title</p><input type="text" name="title" value="<%= title %>" ><br>
 <p class="value1">Quantity</p><input type="text" name="quantity" value="<%= quantity %>"><br>
 <p class="value2">Size</p><input type="text" name="size" value="<%= size %>"><br>
 <p class="image1">Image</p><input type="text" name="image" value="<%= image %>"><br>
  <input type="submit" value="edit">
  <%
String[] data = (String[]) request.getAttribute("data");
if (data != null) {
    out.println("edit success");
}
%>
  
 </div>
</form>
</body>
</html>