<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vurder Prosjekt</title>
</head>
<body>
    <h1>(her skal prosjektet info være)</h1>
<form action="StemmeServlet" method="POST">

<div class="pure-control-group">
    <label for="mobil">Telefonnummer:</label> <input type="text" name="tlf" />
  </div>

  <p>Hvor bra fra 0-5 er prosjektet</p>
<div>
    <input type="radio" id="0" name="rating" value="0">
    <label for="0">0</label><br>

    <input type="radio" id="1" name="rating" value="1">
    <label for="1">1</label><br>

    <input type="radio" id="2" name="rating" value="2">
    <label for="2">2</label><br>

    <input type="radio" id="3" name="rating" value="3">
    <label for="3">3</label><br>

    <input type="radio" id="4" name="rating" value="4">
    <label for="4">4</label><br>

    <input type="radio" id="5" name="rating" value="5">
    <label for="5">5</label><br>

    <div class="pure-controls">
        <button type="submit" class="pure-button pure-button-primary">Send inn</button>
      </div>

</div>
  
</form>

</body>
</html>