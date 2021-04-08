<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/gyldiglegginn.js" defer></script>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Admin - legg til prosjekt</title>
</head>
<body>
	<form action="admin" method="get" class="pure-form pure-form-aligned">
			<fieldset>
				<div class="pure-control-group">
					<p>
						<button type="submit" name="admin"
							class="pure-button pure-button-primary">
								Adminside</button>
					</p>
				</div>
			</fieldset>
	</form>
	<div id="root" >
		<h1>Nytt prosjekt</h1>
		<form action="LeggTilProsjekt" method="post" name="skjema"
			class="pure-form pure-form-aligned">
			<fieldset>
				<div class="pure-control-group">
					<label for="navn">Navn:</label> <input type="text" name="navn" />
				</div>
				<div class="pure-control-group">
					<button type="submit" class="pure-button pure-button-primary">Legg
						til</button>
						<font color="red">${loginMessage}</font>
				</div>
			</fieldset>
		</form>
		<h1>Prosjekter i systemet</h1>

		<table>
			<tr>
				<th>Prosjekt navn</th>
				<th>Kvitering</th>
			</tr>
			<c:forEach var="prosjekt" items="${prosjekter}">
				<tr>
					<td><c:out value="${prosjekt.prosjektnavn}" /></td>
					<td>
						<form action="kvittering" method="get">
							<input type="hidden" name="prosjektnr"
								value="${prosjekt.getProsjektNr()}"> <input type="submit"
								value="se kvitering">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
