<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Admin - legg til prosjekt</title>
</head>
<body>
	<p>
		<font color="red">${loginMessage} </font>
	</p>
	<form action="LeggTilProsjekt" method="post"
		class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="navn">Navn:</label> <input type="text" name="navn" />
			</div>
			<div class="pure-control-group">
				<button type="submit" class="pure-button pure-button-primary">Legg
					til</button>
			</div>
		</fieldset>
	</form>
	<form action="admin" method="get" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<p>
					<button type="submit" name="admin"
						class="pure-button pure-button-primary">Admin</button>
				</p>
			</div>
		</fieldset>
	</form>
	<h1>Prosjektliste</h1>

	<table>
		<tr>
			<th>Prosjekt navn</th>
			<th>Antall stemmer</th>
			<th>Total score</th>
			<th>Gjennomsnittlig score</th>
			<th>Vektet score</th>
			<th>Score</th>
			<th>Kvitering</th>
			<th>Slett</th>
		</tr>
		<c:forEach var="prosjekt" items="${prosjekter}">
			<tr>
				<td><c:out value="${prosjekt.prosjektNavn}" /></td>
				<td><c:out value="${prosjekt.antallStemmer}" /></td>
				<td><c:out value="${prosjekt.totalScore}" /></td>
				<td><c:out value="${prosjekt.gjScore}" /></td>
				<td><c:out value="${prosjekt.vektetScore}" /></td>
				<td><c:out value="${prosjekt.score}" /></td>
				<td>
					<form action="kvittering" method="get">
						<input type="hidden" name="prosjektnr"
							value="${prosjekt.prosjektNr}"> <input type="submit"
							value="se kvitering">
					</form>
				</td>
				<td>
					<form action="slettProsjekt" method="post"
						class="pure-form pure-form-aligned">
						<input type="hidden" name="prosjektNr"
							value="${prosjekt.prosjektNr}"> <input type="submit"
							value="Slett">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>