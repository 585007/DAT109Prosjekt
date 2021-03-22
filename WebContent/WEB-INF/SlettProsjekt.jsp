<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Admin - slett prosjekt</title>
</head>
<body>
	<form action="slettProsjekt" method="post" 
		class="pure-form pure-form-aligned">
	<fieldset>
			<div class="pure-control-group">
				<label for="navn">ProsjektNr:</label> 
				<input type="text" name="prosjektNr" />
			</div>
			<div class="pure-control-group">
				<button type="submit" class="pure-button pure-button-primary">Slett</button>
			</div>
		</fieldset>
	</form>
</body>
</html>