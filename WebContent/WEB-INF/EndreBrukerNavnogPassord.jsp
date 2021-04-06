<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Endre brukernavn og passord </title>
</head>
<body>
  <h2>Endre brukernavn og passord</h2>
  <p>
    <font color="red">${Message} </font>
  </p>
  <form action="EndreBrukerNavnogPassord" method="post" class="pure-form pure-form-aligned">
    <fieldset>
      <div class="pure-control-group">
        <label for="bruker">Brukernavn:</label> 
        <input type="text" name="bruker"/>
      </div>
      <div class="pure-control-group">
        <label for="passord">Passord:</label> 
        <input type="password" name="passord"/>
      </div>
      <div class="pure-control-group">
        <label for="nyttPassord">Nytt passord:</label> 
        <input type="password" name="nyttPassord"/>
      </div>
      <div class="pure-control-group">
        <label for="bekreftPassord">Bekreft passord:</label> 
        <input type="password" name="bekreftPassord"/>
      </div>
      <div class="pure-controls-group">
        <button type="submit" class="pure-button pure-button-primary">Lagre endring</button>
      </div>
    </fieldset>
  </form>

</body>
</html>