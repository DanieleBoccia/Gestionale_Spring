<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<meta charset="UTF-8">
<title>Inserimento Impiegato</title>
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
      <h1>INSERISCI IMPIEGATO</h1>
      
      <form:form action="InserimentoImpiegato" method = "POST" modelAttribute = "impiegato"> 
   
      <form:label path = "nome">NOME</form:label>
      <form:input path="nome"/>
      <form:label path = "cognome">COGNOME</form:label>
      <form:input path="cognome"/>
      <form:label path = "codicefiscale">CODICE FISCALE</form:label>
      <form:input path="codicefiscale"/>
      <form:label path = "matricola">MATRICOLA</form:label>
      <form:input path="matricola"/>
      
      <input type="submit" value="INVIA" />
      
      </form:form>
      
     <p><a href="<c:url value='/'/>" class="a">torna alla home</a></p>
     
      
      </div>
      </body>
      
</html>