<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
    
    
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
<title>RICERCA PER COGNOME</title>
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
<body>  
        

          <table>
       <tr>
          <th>NOME</th>
          <th>COGNOME</th>
          <th>CODICE FISCALE</th>
          <th>MATRICOLA</th>
         
      </tr>
    
           <c:forEach items="${listImpiegati}" var="impiegato">
           
       <tr>
           <td>${impiegato.nome}</td>
           <td>${impiegato.cognome}</td>
           <td>${impiegato.codicefiscale}</td>
           <td>${impiegato.matricola}</td>
          
             <td> 
    
          
                  <form:form action="${pageContext.request.contextPath}/eliminaImpiegato/{matricola}" method="POST">
                    <input type="hidden" name="matricola" value="${impiegato.matricola}" />
                    <button type="submit">Elimina</button>
                  </form:form>
                          
              
              <td>
                    <form:form action="${pageContext.request.contextPath}/preAggiornamentoImpiegato" method="GET" modelAttribute = "impiegato">
                    <input type="hidden" name="id" value="${impiegato.nome}" />
                    <input type="hidden" name="id" value="${impiegato.cognome}" />
                    <input type="hidden" name="id" value="${impiegato.codicefiscale}" />
                    <input type="hidden" name="id" value="${impiegato.matricola}" />
                    <input type="submit" value="Aggiorna"/>
                  </form:form>
            
                   
           
            
           
    </tr>
  </c:forEach>
      
</table>
<a href="Home.jsp"class="a">torna alla home</a>
</body>
</html>