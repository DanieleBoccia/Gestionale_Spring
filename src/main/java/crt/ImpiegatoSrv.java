package crt;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImpDaoImpl;
import dao.ImpiegatoDaoJpa;
import model.Impiegato;

/**
 * Servlet implementation class ImpiegatoSrv
 */
@WebServlet("/ImpiegatoSrv")
public class ImpiegatoSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImpiegatoSrv() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tipoOperazione = request.getParameter("tipoOperazione");
		System.out.println("tipoOperqzione:"+tipoOperazione);
		
		//TIPO OPERAZIONE INSERISCI!!!!!!
		if (tipoOperazione != null && tipoOperazione.equals("inserisci")) {
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String codicefiscale = request.getParameter("codicefiscale");
			int matricola = Integer.parseInt(request.getParameter("matricola"));

			Impiegato impiegato = new Impiegato(nome, cognome, codicefiscale, matricola);

			ImpiegatoDaoJpa impiegatoDao = new ImpiegatoDaoJpa();
				impiegatoDao.insert(impiegato);
			

			request.getRequestDispatcher("/InserimentoImpiegatoOK.jsp").forward(request, response);

			System.out.println(request.getParameter("nome"));
			System.out.println(request.getParameter("cognome"));
			System.out.println(request.getParameter("codicefiscale"));
			System.out.println(Integer.parseInt(request.getParameter("matricola")));
		}

		
		//TIPO OPERAZIONE AGGIORNAMENTO!!!!!!
		if (tipoOperazione != null && tipoOperazione.equals("aggiorna")) {
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String codicefiscale = request.getParameter("codicefiscale");
			int matricola = Integer.parseInt(request.getParameter("matricola"));

			Impiegato impiegato = new Impiegato(nome, cognome, codicefiscale, matricola);

			ImpiegatoDaoJpa impiegatoDao = new ImpiegatoDaoJpa();
			impiegatoDao.update(impiegato);
			

			request.getRequestDispatcher("/AggiornaImpiegatoOk.jsp").forward(request, response);

			System.out.println(request.getParameter("nome"));
			System.out.println(request.getParameter("cognome"));
			System.out.println(request.getParameter("codicefiscale"));
			System.out.println(Integer.parseInt(request.getParameter("matricola")));
		}
	
			  
        //TIPO OPERAZIONE RICERCA PER CODICE FISCALE!!!!
		if (tipoOperazione != null && tipoOperazione.equals("ricercaPerCodicefiscale")) {
			String codicefiscale = request.getParameter("codicefiscale");

			ImpiegatoDaoJpa impiegatoDao = new ImpiegatoDaoJpa();
			
				Impiegato impiegato = impiegatoDao.findCodiceFiscale(codicefiscale);
				if (impiegato != null) {

					request.getSession().setAttribute("impiegato", impiegato);
					request.getRequestDispatcher("/AggiornaImpiegato.jsp").forward(request, response);

				} else {
					request.getRequestDispatcher("/ricercaImpiegatoKo.jsp").forward(request, response);
				}
		}

		
		//TIPO OPERAZIONE RICERCA PER COGNOME!!!!!
		/*if (tipoOperazione != null && tipoOperazione.equals("ricercaPerCognome")) {
			
			  String cognome = request.getParameter("cognome");
	            System.out.println("Ricerca Per Cognome:"+cognome);
			    
	            ImpiegatoDaoJpa impiegatoDao = new ImpiegatoDaoJpa();
			    
				List<Impiegato> impiegato = impiegatoDao.findCognome(cognome);
				if (impiegato != null && !impiegato.isEmpty()) {
					
					request.getSession().setAttribute("impiegato", impiegato);
					RequestDispatcher rd = request.getRequestDispatcher("/RicercaImpiegatoPerCognomeOk.jsp");
					rd.forward(request, response);
				
				 } else {
					request.getRequestDispatcher("/ricercaImpiegatoKo.jsp").forward(request, response);
				 }
	    }*/
		
		
		//TIPO OPERAZIONE ELIMINA!!!!!
		if (tipoOperazione != null && tipoOperazione.equals("elimina")) {
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String codicefiscale = request.getParameter("codicefiscale");
			int matricola = Integer.parseInt(request.getParameter("matricola"));
			
			Impiegato impiegato = new Impiegato(nome, cognome, codicefiscale, matricola);
			
			ImpiegatoDaoJpa impiegatoDao = new ImpiegatoDaoJpa();
			 
			    impiegatoDao.delete(matricola);
			    if (impiegato != null) {
			    	impiegatoDao.findCognome(cognome);
			    	
			    }
				
			    RequestDispatcher rd = request.getRequestDispatcher("/RicercaImpiegatoPerCognomeOk.jsp");
				rd.forward(request, response);
				System.out.println("IMPIEGATO ELIMINATO");
			    
		      }
	}

	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);

	}

}
