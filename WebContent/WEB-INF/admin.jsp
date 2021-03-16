<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

  <form action="logginn" method="post" class="pure-form pure-form-aligned">
    <fieldset>
      <div class="pure-control-group">
        <p>
          <button type="submit" name="leggTil" class="pure-button pure-button-primary" value="meldpå">Legg til et prosjekt</button>
        </p>
      </div>
    </fieldset>
  </form>
  <form action="prosjektListe" method="post" class="pure-form pure-form-aligned">
    <fieldset>
      <div class="pure-control-group">
        <p>
          <button type="submit" name="prosjektListe" class="pure-button pure-button-primary" value="meldpå">Vis liste over prosjekt med poeng</button>
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

</body>
</html>