<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>



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
  <h1>${prosjektNavn}</h1>

  <form action="kvittering" method="post">
    <div id=id>
      <h2>www.${prosjektNavn}.no</h2>
      <canvas id="qr-code"></canvas>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/qrious/4.0.2/qrious.min.js"></script>
        <script>
			var qr;
			(function() {
				qr = new QRious(
					{
					element : document.getElementById('qr-code'),
					size : 200,
					value : 'https://www.${prosjektNavn}.no' <!-- må fikses til aktuell side -->
					});
				})();
		</script>

      <p>
        <button type="submit" name="button" value="Ferdig">Ferdig</button>
      </p>
    </div>
  </form>
</body>
</html>