package crt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RuoloDaoJpa;
import model.Ruolo;

/**
 * Servlet implementation class RuoloSrv
 */
@WebServlet("/RuoloSrv")
public class RuoloSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RuoloSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoOperazione = request.getParameter("tipoOperazione");
        if (tipoOperazione != null && tipoOperazione.equals("inserisci")) {
            int idRuolo = Integer.parseInt(request.getParameter("idRuolo"));
            String Descrizione = request.getParameter("Descrizione");
            
            Ruolo rol = new Ruolo(idRuolo, Descrizione);
            
            RuoloDaoJpa Dao = new RuoloDaoJpa();
            Dao.insert(rol);
            
            request.getRequestDispatcher("/InserimentoRuoloOK.jsp").forward(request, response);
            
            System.out.println(Integer.parseInt(request.getParameter("idRuolo")));
            System.out.println(request.getParameter("Descrizione"));
        }
        
        if (tipoOperazione != null && tipoOperazione.equals("aggiorna")) {
                int idRuolo = Integer.parseInt(request.getParameter("idRuolo"));
                String Descrizione = request.getParameter("Descrizione");
                
                Ruolo rol = new Ruolo(idRuolo, Descrizione);
                
                RuoloDaoJpa Dao = new RuoloDaoJpa();
                Dao.update(rol);
                
                request.getRequestDispatcher("/AggiornaRuoloOk.jsp").forward(request, response);
                
                System.out.println(Integer.parseInt(request.getParameter("idRuolo")));
                System.out.println(request.getParameter("Descrizione"));
            }
            
        if (tipoOperazione != null && tipoOperazione.equals("elimina")) {
                int idRuolo = Integer.parseInt(request.getParameter("idRuolo"));
                
                
                RuoloDaoJpa Dao = new RuoloDaoJpa();
                Dao.delete(idRuolo);
                
                response.setContentType("text/html");
                response.getWriter().write("Ruolo eliminato con successo");
                
                System.out.println(Integer.parseInt(request.getParameter("idRuolo")));
                System.out.println(request.getParameter("Descrizione"));
            }
        
        
        
        if (tipoOperazione != null && tipoOperazione.equals("ricercaPerIdRuolo")) {
        	int idRuolo = Integer.parseInt(request.getParameter("idRuolo"));
            
            
        	RuoloDaoJpa Dao = new RuoloDaoJpa();
        	Ruolo rol = Dao.find(idRuolo);
        	if (rol != null) {
        	request.getSession().setAttribute("rol", rol);
        	request.getRequestDispatcher("/AggiornaRuolo.jsp").forward(request, response);
        	} else {
        	request.getRequestDispatcher("/ricercaRuoloKo.jsp").forward(request, response);
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
