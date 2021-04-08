<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="js/gyldigendre.js" defer></script>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Endre passord</title>
</head>
<body>
	<h2>Endre passord</h2>
	<p>
		<font color="red">${Message} </font>
	</p>
	<div id="root">
		<form action="EndrePassord" method="post"
			class="pure-form pure-form-aligned" name="skjema">
			<fieldset>
				<div class="pure-control-group">
					<label for="bruker">Brukernavn:</label> <input type="text"
						name="bruker" required />
				</div>
				<div class="pure-control-group">
					<label for="passord">Passord:</label> <input type="password"
						name="passord" required />
				</div>
				<div class="pure-control-group">
					<label for="nyttPassord">Nytt passord:</label> <input
						type="password" name="nyttPassord" required />
				</div>
				<div class="pure-control-group">
					<label for="bekreftPassord">Bekreft passord:</label> <input
						type="password" name="bekreftPassord" required />
				</div>
				<div class="pure-controls-group">
					<button id="submit" type="submit"
						class="pure-button pure-button-primary">Lagre endring</button>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>
