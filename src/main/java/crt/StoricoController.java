package crt;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Storico;
import dao.StoricoDaoJpa;

@Controller
public class StoricoController {
	
	@Autowired
	private StoricoDaoJpa Dao;
	
	@RequestMapping(value = "/InserimentoStorico", method= RequestMethod.POST)
	public String inserimentoStorico(@ModelAttribute Storico str, Model model) {
		
		Dao.insert(str);
		model.addAttribute("storico", str);
		
		return "InserimentoStoricoOK";
	}
	
	@RequestMapping(value = "/AggiornamentoStorico", method= RequestMethod.POST)
	public String aggiornamentoStorico(@ModelAttribute Storico str, Model model) {
		
	    Dao.update(str);
		model.addAttribute("storico", str);
		
		return "AggiornamentoStoricoOK";
	}
	
	@RequestMapping(value = "/ricercaStoricoPerIdStorico/{idStorico}", method= RequestMethod.POST)
	public String ricercaPerIdStorico(@PathVariable int idStorico, Model model) {
		Storico str = Dao.find(idStorico);
		if(str != null) {
			model.addAttribute("storico", str);
			return "AggiornaStorico";
		}
		else {
			return "ricercaStoricoKo";
		}
	}
	
	//@RequestMapping(value = "/{idStorico}", method= RequestMethod.POST)
	//public void eliminaStorico(@RequestBody int idStorico) {
		
	    //Dao.delete(idStorico);
	    
	    //System.out.println("Storico eliminato con successo");
		
	//}

	
}
