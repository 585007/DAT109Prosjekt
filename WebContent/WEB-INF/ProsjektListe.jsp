
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prosjektliste</title>
</head>
<body>
	<h1> Prosjektliste </h1>

	<table>
	<tr>
		<th>Prosjekt navn</th>
		<th>Antall stemmer</th>
		<th>Score</th>
	</tr>
	<c:forEach var="prosjekt" items="prosjekter">
		<tr>
			<td> <c:out value="${prosjekt.prosjektNavn}"/> </td>
			<td> <c:out value="${prosjekt.stemmer.antall}"/> </td>
			<td> <c:out value="${prosjekt.stemmer.score}"/> </td>
			<td> <form>
				<input type="hidden" value="${prosjekt.prosjektNavn}">
				<input type="submit"value="utskriftside">
				</form></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>