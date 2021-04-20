<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="js/gyldiglogginn.js" defer></script>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Logg inn</title>
</head>
<body>
	<div id="root">
		<h2>Logg inn</h2>
		<p>
			<font color="red">${loginMessage} </font>
		</p>
		<form action="logginn" method="post" name="skjema"
			class="pure-form pure-form-aligned">
			<fieldset>
				<div class="pure-control-group">
					<label for="bruker">Brukernavn:</label> <input type="text"
						name="bruker" value="" required />
				</div>
				<div class="pure-control-group">
					<label for="passord">Passord:</label> <input type="password"
						name="passord" value="" required />
				</div>
				<div class="pure-controls-group">
					<button type="submit" id="submit" class="pure-button pure-button-primary">Logg
						inn</button>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>
