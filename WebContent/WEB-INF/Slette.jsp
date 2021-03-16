<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Slette stemme</title>
</head>
<body>
<form action="SletteServlet" method="POST">
<p> Du har stemt på: ${stand.standName}
    <div class="pure-controls">
        <button type="submit" class="pure-button pure-button-primary">Slett stemme</button>
      </div>
</form>
</body>
</html>