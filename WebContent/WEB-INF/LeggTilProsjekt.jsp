<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Admin - legg til prosjekt</title>
</head>
<body>
	<form action="LeggTilProsjekt" method="post"
		class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="navn">Navn:</label> <input type="text" name="navn" />
			</div>
			<div class="pure-control-group">
				<button type="submit" class="pure-button pure-button-primary">Legg
					til</button>
			</div>
		</fieldset>
	</form>
	<form action="admin" method="get" class="pure-form pure-form-aligned">
    <fieldset>
      <div class="pure-control-group">
        <p>
          <button type="submit" name="admin" class="pure-button pure-button-primary">Admin</button>
        </p>
      </div>
    </fieldset>
  </form>
</body>
</html>