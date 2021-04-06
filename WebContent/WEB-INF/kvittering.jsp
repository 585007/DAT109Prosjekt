<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<style>
body {
	padding: 20px;
}

input {
	padding: 5px;
	background-color: transparent;
	border: none;
	border-bottom: solid 4px #8c52ff;
	width: 250px;
	font-size: 16px;
}

.qr-btn {
	background-color: #8c52ff;
	padding: 8px;
	color: white;
	cursor: pointer;
}
</style>
<meta charset="ISO-8859-1">
<title>Kvittering</title>
</head>
<body>
	<h1>${prosjekter.prosjektnavn}</h1>

	<form action="kvittering" method="post">
			<h2>http://localhost:8080/dat109-prosjekt-gr5/StemmeServlet?prosjektId=${prosjekter.getProsjektNr()}</h2>
			<canvas id="qr-code"></canvas>

			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/qrious/4.0.2/qrious.min.js"></script>
			<script>
			var qr;
			(function() {
				qr = new QRious(
					{
					element : document.getElementById('qr-code'),
					size : 200,
					value : 'http://localhost:8080/dat109-prosjekt-gr5/StemmeServlet?prosjektId=${prosjekter.getProsjektNr()}' <!-- må fikses til aktuell side -->
					});
				})();
		</script>
			<div class="pure-control-group">
					<button type="submit" name="Ferdig"
						class="pure-button pure-button-primary">Ferdig</button>
			</div>
	</form>
	<form action="LeggTilProsjekt" method="get" class="pure-form pure-form-aligned">
      <div class="pure-control-group">
          <button type="submit" name="LeggTilProsjekt" class="pure-button pure-button-primary">Leggtil nytt prosjekt</button>
      </div>
  </form>
</body>
</html>