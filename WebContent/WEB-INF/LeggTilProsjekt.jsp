<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin legg til prosjekt</title>
</head>
<body>
	<form action="LeggTilProsjekt" method="post"
		class="pure-form pure-form-aligned">
		<div class="pure-control-group">
			<label>Navn:</label> <input type="text" name="navn" />
		</div>
		<div class="pure-controls">
        <button type="submit" class="pure-button pure-button-primary">Legg til</button>
      </div>
	</form>
</body>
</html>