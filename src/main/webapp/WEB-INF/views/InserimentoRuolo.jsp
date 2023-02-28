<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "f"%>
   
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<meta charset="UTF-8">
<title>Inserimento Ruolo</title>
 <style>
  .rectangle {
    border-left: 7px outset #0066A2;
    padding: 10px;
  }
  .a {
  color: blue; 
  text-decoration: none; 

}

<h3 id="heading-1" class="ui-bar ui-bar-a ui-corner-all">Heading</h3>
<div class="ui-body ui-body-a ui-corner-all">
	<p>Content</p>
</div>
font: bold 15px arial, sans-serif;

text-shadow:none;

}
</style>
</head>
<body>


<div class="rectangle">
      <h1>INSERISCI RUOLO</h1>
      
      <f:form action="InserimentoRuolo" method = "POST" modelAttribute = "ruolo"> 
   
      <f:label path = "idRuolo">ID RUOLO</f:label>
      <f:input path="idRuolo"/>
      <f:label path = "Descrizione">DESCRIZIONE</f:label>
      
      <input type="submit" value="INVIA" />
      
      </f:form>
      
     
      <p><a href="Home.jsp"class="a">torna alla home</a></p>
      </div>
      </body>
      
</html>