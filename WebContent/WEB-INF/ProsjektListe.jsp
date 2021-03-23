<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prosjektliste </title>
</head>
<body>
	<h1> Prosjektliste </h1>

	<table>
	<tr>
		<th>Prosjekt navn</th>
		<th>Antall stemmer</th>
		<th>Total score</th>
		<th>Gjennomsnittlig score</th>
		<th>Vektet score</th>
		<th>Score</th>
	</tr>
	<c:forEach var="prosjekt" items="${prosjekter}">
		<tr>
			<td> <c:out value="${prosjekt.prosjektNavn}"/> </td>
			<td> <c:out value="${prosjekt.antallStemmer}"/> </td>
			<td> <c:out value="${prosjekt.totalScore}"/> </td>
			<td> <c:out value="${prosjekt.gjScore}"/> </td>
			<td> <c:out value="${prosjekt.vektetScore}"/> </td>
			<td> <c:out value="${prosjekt.score}"/> </td>
			<td> <form action="kvittering" method="get" >
				<input type="hidden" name=prosjektnr value="${prosjekt.prosjektNr}">
				<input type="submit" value="se kvitering">
				</form></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>