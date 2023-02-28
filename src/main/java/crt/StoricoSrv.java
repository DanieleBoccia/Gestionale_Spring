package crt;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StoricoDaoImpl;
import dao.StoricoDaoJpa;
import model.Storico;

/**
 * Servlet implementation class StoricoSrv
 */
@WebServlet("/StoricoSrv")
public class StoricoSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoricoSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String tipoOperazione = request.getParameter("tipoOperazione");
	        if (tipoOperazione != null && tipoOperazione.equals("inserisci")) {
	        	int idStorico = Integer.parseInt(request.getParameter("idStorico"));
	        	  int idRuolo = Integer.parseInt(request.getParameter("idRuolo"));
	        	  int matricola = Integer.parseInt(request.getParameter("matricola"));
	        	  
	        	  // Crea un oggetto SimpleDateFormat per la conversione delle date
	        	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        	  
	        	  // Converte le date dal formato (dd/MM/yyyy) a java.sql.Date
	        	  java.util.Date dataInizioUtil = null;
	        	  java.util.Date dataFineUtil = null;
	        	  
	        	    try {
						dataInizioUtil = dateFormat.parse(request.getParameter("dataInizio"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	    try {
						dataFineUtil = dateFormat.parse(request.getParameter("dataFine"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	 
	        	  java.sql.Date dataInizioSql = new java.sql.Date(dataInizioUtil.getTime());
	        	  java.sql.Date dataFineSql = new java.sql.Date(dataFineUtil.getTime());
	        	  
	        	  // Crea un oggetto Storico con i dati del form
	        	  Storico storico = new Storico(idStorico, idRuolo, matricola, dataInizioSql, dataFineSql);
	        	  
	        	  // Chiama il metodo insertStorico del DAO
	        	  StoricoDaoJpa dao = new StoricoDaoJpa();
	        	  dao.insert(storico);
				request.getRequestDispatcher("/InserimentoStoricoOK.jsp").forward(request, response);
	        	
	        	
	        	
	        	  System.out.println(request.getParameter("idStorico"));
		          System.out.println(request.getParameter("idRuolo"));
		          System.out.println(request.getParameter("matricola"));
		          System.out.println(request.getParameter("dataInizio"));
		          System.out.println(request.getParameter("dataFine"));
	  }
	            
	     
	        
	        
	        if (tipoOperazione != null && tipoOperazione.equals("aggiorna")) {
	        	int idStorico = Integer.parseInt(request.getParameter("idStorico"));
	        	int idRuolo = Integer.parseInt(request.getParameter("idRuolo"));
	        	int matricola = Integer.parseInt(request.getParameter("matricola"));
	        	  
	        	  // Crea un oggetto SimpleDateFormat per la conversione delle date
	        	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        	  
	        	  // Converte le date dal formato (dd/MM/yyyy) a java.sql.Date
	        	  java.util.Date dataInizioUtil = null;
	        	  java.util.Date dataFineUtil = null;
	        	  try {
	        	    dataInizioUtil = dateFormat.parse(request.getParameter("dataInizio"));
	        	    dataFineUtil = dateFormat.parse(request.getParameter("dataFine"));
	        	  } catch (ParseException e) {
	        	    e.printStackTrace();
	        	  }
	        	  java.sql.Date dataInizioSql = new java.sql.Date(dataInizioUtil.getTime());
	        	  java.sql.Date dataFineSql = new java.sql.Date(dataFineUtil.getTime());
	        	  
	        	  // Crea un oggetto Storico con i dati del form
	        	  Storico storico = new Storico(idStorico, idRuolo, matricola, dataInizioSql, dataFineSql);
	        	  
	        	  // Chiama il metodo insertStorico del DAO
	        	  StoricoDaoJpa dao = new StoricoDaoJpa();
	        	  dao.update(storico);
				request.getRequestDispatcher("/AggiornaStoricoOk.jsp").forward(request, response);
	        	
	        	
	        	
	        	  System.out.println(request.getParameter("idStorico"));
		          System.out.println(request.getParameter("idRuolo"));
		          System.out.println(request.getParameter("matricola"));
		          System.out.println(request.getParameter("dataInizio"));
		          System.out.println(request.getParameter("dataFine"));
	  }
	            
	        
	        
	        if (tipoOperazione != null && tipoOperazione.equals("elimina")) {
	        	int idStorico = Integer.parseInt(request.getParameter("idStorico"));
	        	  
	        	  StoricoDaoJpa dao = new StoricoDaoJpa();
	        	  dao.delete(idStorico);
				  response.setContentType("text/html");
				  response.getWriter().write("Eliminazione effettuata con successo");
	        	
	        	
	        	
	        	  System.out.println(request.getParameter("idStorico"));
		          System.out.println(request.getParameter("idRuolo"));
		          System.out.println(request.getParameter("matricola"));
		          System.out.println(request.getParameter("dataInizio"));
		          System.out.println(request.getParameter("dataFine"));
	  }
	            
	            
	        
	         
	        if (tipoOperazione != null && tipoOperazione.equals("ricercaPerIdStorico")) {
	            int idStorico = Integer.parseInt(request.getParameter("idStorico"));

	            StoricoDaoJpa strDao = new StoricoDaoJpa();
	            
	                Storico str = strDao.find(idStorico);
	                if(str != null) {
	                	request.getSession().setAttribute("str", str);
	                    request.getRequestDispatcher("/AggiornaStorico.jsp").forward(request, response);
	                }else {
	                	request.getRequestDispatcher("/ricercaStoricoKo.jsp").forward(request, response);
	                }
	           
	            
	        }
	       
	        
	        
	        
	       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
