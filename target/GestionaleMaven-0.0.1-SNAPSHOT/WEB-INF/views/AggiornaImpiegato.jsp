<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "f"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="model.Impiegato" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<meta charset="UTF-8">
<title>Aggiornamento Impiegato</title>
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
      <h1>AGGIORNA IMPIEGATO</h1>
      
         <f:form action="${pageContext.request.contextPath}/RicercaPerCodiceFiscale" method="POST" modelAttribute="impiegato">
            <f:label path = "nome">NOME</f:label>
            <f:input path="nome"/>
            
            <f:label path = "cognome">COGNOME</f:label>
            <f:input path="cognome"/>
            
            <f:label path = "codicefiscale">CODICE FISCALE</f:label>
            <f:input path="codicefiscale"/>
            
            <f:label path = "matricola">MATRICOLA</f:label>
            <f:input path="matricola"/> 
            
            <br>
            
            <input type="submit" value="INVIA" />
        </f:form>
        
            
      <a href="Home.jsp"class="a">torna alla home</a>
      </div>
      </body>
      
</html>