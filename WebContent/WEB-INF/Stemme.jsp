<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1" name="viewport" content="device-width, initial-scale=1">


		<link rel="stylesheet" href="css/style.css">
	<title>Vurder Prosjekt ${prosjektNavn}</title>
	</head>
	<body class = "mid background">
		<div id="root">
			<h1 >${prosjektNavn}</h1>
			<form action="StemmeServlet" method="post" name="skjema"
				class="pure-form pure-form-aligned">
				<input type="hidden" name="prosjektNavn" value=${prosjektNavn}>
				<input type="hidden" name="prosjektId" value=${prosjektId}>
				<div>
					 <input type="text"  placeholder = "Telefonnummer"
						name="tlf" pattern="\d*" title = "Bare tall er akseptert" required />
				</div>
	
				<p>Hvor bra fra 1-5 er prosjektet <br> (5 best, 1 verst)</p>
	
				<div>
				
					<input type="radio" id="0" name="rating" value="0" required>
					<label for="0">Ikke stem</label><br> <input type="radio" id="1"
						name="rating" value="1" required> <label for="1">1</label><br>
	
					<input type="radio" id="2" name="rating" value="2" required>
					<label for="2">2</label><br> <input type="radio" id="3"
						name="rating" value="3" required> <label for="3">3</label><br>
	
					<input type="radio" id="4" name="rating" value="4" required>
					<label for="4">4</label><br> <input type="radio" id="5"
						name="rating" value="5" required> <label for="5">5</label><br><br>
					
					
					
					<div>
						<button type="submit" class="pure-button pure-button-primary">Send
							inn</button>
					</div>
	
				</div>
			</form>
		</div>
	</body>
	</html>
