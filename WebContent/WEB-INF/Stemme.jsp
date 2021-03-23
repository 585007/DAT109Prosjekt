<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vurder Prosjekt ${prosjektNavn}</title>
</head>
<body>
	<h1>${prosjektNavn}</h1>
	<form action="StemmeServlet" method="POST">
		<input type="hidden" name="prosjektNavn" value=${prosjektNavn}>
		<input type="hidden" name="prosjektId" value=${prosjektId}>

		<div class="pure-control-group">

			<label for="mobil">Telefonnummer:</label> <input type="text"
				name="tlf" required />

		</div>

		<p>Hvor bra fra 0-5 er prosjektet (5 best, 0 verst)</p>
		<div>

			<input type="radio" id="0" name="rating" value="0" required>
			<label for="0">0</label><br> <input type="radio" id="1"
				name="rating" value="1" required> <label for="1">1</label><br>

			<input type="radio" id="2" name="rating" value="2" required>
			<label for="2">2</label><br> <input type="radio" id="3"
				name="rating" value="3" required> <label for="3">3</label><br>

			<input type="radio" id="4" name="rating" value="4" required>
			<label for="4">4</label><br> <input type="radio" id="5"
				name="rating" value="5" required> <label for="5">5</label><br>

			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Send
					inn</button>
				<font color="red">${loginMessage}</font>
			</div>

		</div>

	</form>

</body>
</html>