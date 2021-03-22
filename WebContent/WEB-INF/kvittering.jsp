<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<style>
body {
	padding: 20px;
}

input {
	padding: 5px;
	background-color: transparent;
	border: none;
	border-bottom: solid 4px #8c52ff;
	width: 250px;
	font-size: 16px;
}

.qr-btn {
	background-color: #8c52ff;
	padding: 8px;
	color: white;
	cursor: pointer;
}
</style>
<meta charset="ISO-8859-1">
<title>Kvittering</title>
</head>
<body>
  <h1>${prosjektNavn} </h1>
<p>takk for din stemme på ${prosjektNavn}</p>
</body>
</html>