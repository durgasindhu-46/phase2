<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details page</title>
</head>
<body>

<h1>Ecommerce Website</h1>
<hr>
<hr>
<h3>Displaying the Product Details....</h3>
<%= "Product Id : " + session.getAttribute("pid") %> <br> <br>
<%= "Product Name : " + session.getAttribute("pname") %>  <br> <br>
<%= "Product Price : " + session.getAttribute("pprice") %>
</body>
</html>
