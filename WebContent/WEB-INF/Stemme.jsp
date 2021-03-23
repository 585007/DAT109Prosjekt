<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
    <title>Vurder Prosjekt ${prosjektNavn}</title>
    </head>
    <body>
    <form action="StemmeServlet" method="POST" class="pure-form pure-form-aligned">
         <input type="hidden" name="prosjektNavn" value=${prosjektNavn}>
         <input type="hidden" name="prosjektId" value=${prosjektId}>
    
    <div class="pure-controls">
    	<h1>${prosjektNavn}</h1>
    	
        <label for="mobil"></label> <input type="text" placeholder="Telefonnummer" pattern="\d*" name="tlf"  required />
    
      </div>
    
      
    <div class="pure-controls">
    <p>Hvor bra fra 1-5 er prosjektet</p>
      <p>(5 best, 1 verst)</p>
    
        <input type="radio" id="0" name="rating" value="0" required>
        <label for="0">(ingen formening)</label><br>
    
        <input type="radio" id="1" name="rating" value="1" required>
        <label for="1">1</label><br>
    
        <input type="radio" id="2" name="rating" value="2" required>
        <label for="2">2</label><br>
    
        <input type="radio" id="3" name="rating" value="3" required>
        <label for="3">3</label><br>
    
        <input type="radio" id="4" name="rating" value="4" required>
        <label for="4">4</label><br>
    
        <input type="radio" id="5" name="rating" value="5" required>
        <label for="5">5</label><br>
    
        <div>
            <button type="submit" class="pure-button pure-button-primary">Send inn</button>
          </div>
    
    </div>
      
    </form>
    
    </body>
    </html>