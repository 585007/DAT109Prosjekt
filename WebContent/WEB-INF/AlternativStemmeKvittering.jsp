<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
<style>
body {
	padding: 20px;
}
=======
<meta charset="ISO-8859-1">
<title>Takk for stemmen!</title>

<h1>Her skal det komme opp rating, og ka du ratet</h1>
</head>
<body>
>>>>>>> branch 'main' of https://github.com/585007/DAT109Prosjekt.git

input {
	padding: 5px;
	baody>
  <h1>${prosjektNavn} </h1>

  <form action="kvittering" method="post">
    <div id=id>
      <h2>http://localhost:8080/dat109-prosjekt-gr5/StemmeServlet?prosjektID=${prosjektNavn}</h2>
      <canvas id="qr-code"></canvas>

// skal qr koden være på kvitteringen???
        <script src="https://cdnjs.cloudflare.com/ajax/libs/qrious/4.0.2/qrious.min.js"></script>
        <script>
			var qr;
			(function() {
				qr = new QRious(
					{
					element : document.getElementById('qr-code'),
					size : 200,
					value : 'http://data1.hib.no:9090/dat109-prosjekt-gr5/StemmeServlet?prosjektId${prosjektId}' <!--litt usikker men noe sånt -->
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