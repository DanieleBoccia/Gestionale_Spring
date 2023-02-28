package crt;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ImpiegatoDaoJpa;
import model.Impiegato;

@Controller
public class ImpiegatoController {
	
	@Autowired
	private ImpiegatoDaoJpa Dao;
	
	
	@RequestMapping(value = "/preInserimentoImpiegato", method = RequestMethod.GET)
	public String preInserimentoImpiegato(Model model) {
	    Impiegato imp = new Impiegato();
	    model.addAttribute("impiegato", imp);
	    return "InserimentoImpiegato";
	}
	
	@RequestMapping(value = "/InserimentoImpiegato", method= RequestMethod.POST)
	public String inserimentoImpiegato(@ModelAttribute Impiegato imp, Model model) {
		
		Dao.insert(imp);
		model.addAttribute("impiegato", imp);
		
		return "InserimentoImpiegatoOK";
	}
	
	@RequestMapping(value = "/preAggiornamentoImpiegato", method = RequestMethod.GET)
	public String preAggiornamentoImpiegato(Model model) {
	    Impiegato imp = new Impiegato();
	    model.addAttribute("impiegato", imp);
	    return "AggiornaImpiegato";
	}
	
	@RequestMapping(value = "/AggiornaImpiegato", method= RequestMethod.POST)
	public String aggiornaImpiegato(@ModelAttribute Impiegato imp, Model model) {
		
		Dao.update(imp);
		model.addAttribute("impiegato", imp);
		
		return "AggiornaImpiegatoOk";
   }
	
	@RequestMapping(value = "/preRicercaImpiegatoPerCodiceFiscale", method = RequestMethod.GET)
	public String preRicercaPerCodiceFiscale(Model model) {
	    model.addAttribute("codicefiscale", "");
	    model.addAttribute("impiegato", new Impiegato());
	   
	    return "ricercaImpiegatoPerCodiceFiscale";
	}
	
	@RequestMapping(value = "/ricercaImpiegatoPerCodiceFiscale/{codicefiscale}", method= RequestMethod.POST)
	public String ricercaImpiegatoPerCodiceFiscale(@RequestParam("codicefiscale") String codicefiscale, Model model) {
	    
		Impiegato imp = Dao.findCodiceFiscale(codicefiscale);
	
		if(imp != null) {
			model.addAttribute("impiegato", imp);
			return "AggiornaImpiegato";
		}
		else {
			model.addAttribute("impiegato", imp);
			System.out.println("Impiegato non trovato");
			return "ricercaImpiegatoKo";
		}
	}
	
	@RequestMapping(value = "eliminaImpiegato/{matricola}", method= RequestMethod.POST)
	public String eliminaImpiegato(@RequestParam("matricola") int matricola, Model model) {
		
	    Dao.delete(matricola);
	    model.addAttribute("impiegato");
	    
	    return "RicercaImpiegatoPerCognomeOk";
		
	}
	
	@RequestMapping(value = "/preRicercaImpiegatoPerCognome", method = RequestMethod.GET)
	public String preRicercaPerCognome(Model model) {
	    model.addAttribute("cognome", "");
	    model.addAttribute("impiegato", new Impiegato());

	    return "ricercaImpiegatoPerCognome";
	}
	
	@RequestMapping(value = "/ricercaImpiegatoPerCognome/{cognome}", method= RequestMethod.POST)
	public String ricercaImpiegatoPerCognome(@RequestParam("cognome") String cognome, Model model) {
		List<Impiegato> listImpiegati = Dao.findCognome(cognome);
		if(listImpiegati != null) {
			
			model.addAttribute("listImpiegati", listImpiegati);
			model.addAttribute("impiegato", new Impiegato());
			return "RicercaImpiegatoPerCognomeOk";
		}
		else {
			return "ricercaImpiegatoKo";
		}
	}
}