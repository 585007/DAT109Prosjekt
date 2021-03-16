<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Admin</title>
</head>
<body>
  <h2>Admin</h2>
<form action="admin" method="post" class="pure-form pure-form-aligned">
  <form action="leggTil" method="post" class="pure-form pure-form-aligned">
    <fieldset>
      <div class="pure-control-group">
        <p>
          <button type="submit" name="leggTil" class="pure-button pure-button-primary" value="meldpå">Legg til et prosjekt</button>
        </p>
      </div>
    </fieldset>
  </form>
  <form action="ProsjektListeServlet" method="post" class="pure-form pure-form-aligned">
    <fieldset>
      <div class="pure-control-group">
        <p>
          <button type="submit" name="ProsjektListeServlet" class="pure-button pure-button-primary" value="meldpå">Vis liste over prosjekt med poeng</button>
        </p>
      </div>
    </fieldset>
  </form>
  <form action="slett" method="post" class="pure-form pure-form-aligned">
    <fieldset>
      <div class="pure-control-group">
        <p>
          <button type="submit" name="slett" class="pure-button pure-button-primary" value="meldpå">Slett prosjekt</button>
        </p>
      </div>
    </fieldset>
  </form>
  </form>

</body>
</html>