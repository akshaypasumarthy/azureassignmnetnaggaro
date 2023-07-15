<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
  <thead>
    <tr>
      <th>title</th>
      <th>quantity</th>
      <th>size</th>
      <th>Image</th>
    </tr>
  </thead>
  <tbody>
  <% 
  List<String[]> records = (List<String[]>) request.getAttribute("dataList");
  %>
    <% for(String[] record : records){ %>
      <tr>
        <td><%= record[0] %></td>
        <td><%= record[1] %></td>
        <td><%= record[2] %></td>
        <td><img src="<%= record[3] %>" > </td>
       
        
        
        
        
        <td><a href="edit.jsp?title=<%= record[0] %>&quantity=<%= record[1] %>&size=<%= record[2] %>&image=<%= record[3] %>">edit</a><a href="delete">delete</a></td>
         <%} %>
      </tr>
  </tbody>
</table>
</body>
</html>