<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix = "f"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<meta charset="UTF-8">
<title>Home Page</title>
 <style>
  .rectangle {
    border-left: 7px outset #0066A2;
    padding: 10px;
  }
  .a {
  color: blue; 
  text-decoration: none; 

}
  </style>
</head>
<body>
<div class="rectangle">
  <h1>Benvenuti alla Home Page</h1>
  <h2>Scegli una delle seguenti opzioni:</h2>
  <ul>
    <h3>IMPIEGATO</h3>
    
    <f:form action="/" method="POST">
    
    <li><a href="<c:url value='preInserimentoImpiegato'/>" class="a">INSERISCI IMPIEGATO</a></li>    
    <h4>Ricerca</h4>
    
    <li><a href="<c:url value='preRicercaImpiegatoPerCognome'/>" class="a">CERCA IMPIEGATO PER COGNOME</a></li>    
    <li><a href="<c:url value='preRicercaImpiegatoPerCodiceFiscale'/>" class="a">CERCA IMPIEGATO PER CODICE FISCALE</a></li>    
    
     <h3>RUOLO</h3>
    
    <li><a href="InserimentoRuolo.jsp"class="a">INSERISCI RUOLO</a></li>
    
    <h4>Ricerca</h4>
    
    <li><a href="ricercaRuoloPerIdRuolo.jsp"class="a">CERCA RUOLO IMPIEGATO</a></li>
    
     <h3>STORICO</h3>
    
    <li><a href="InserimentoStorico.jsp"class="a">INSERISCI STORICO</a></li>
    
    <h4>Ricerca</h4>
    
    <li><a href="ricercaStoricoPerIdStorico.jsp"class="a">CERCA STORICO IMPIEGATO</a></li>
    
     </f:form>
  </ul>
  </div>
</body>
</html>