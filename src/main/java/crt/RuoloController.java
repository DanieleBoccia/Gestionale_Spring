package crt;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.RuoloDaoJpa;
import model.Ruolo;
	
	@Controller
	public class RuoloController {
		
		@Autowired
		private RuoloDaoJpa Dao;
		
		@RequestMapping(value = "/InserimentoRuolo", method= RequestMethod.POST)
		public String inserimentoRuolo(@ModelAttribute Ruolo rol, Model model) {
			
			Dao.insert(rol);
			model.addAttribute("ruolo", rol);
			
			return "InserimentoRuoloOK";
		}
		
		@RequestMapping(value = "/AggiornaRuolo", method= RequestMethod.POST)
		public String aggiornamentoRuolo(@ModelAttribute Ruolo rol, Model model) {
			
			Dao.insert(rol);
			model.addAttribute("ruolo", rol);
			
			return "AggiornamentoRuoloOK";
		}
		
		@RequestMapping(value = "/ricercaRuoloPerIdRuolo/{idRuolo}", method= RequestMethod.POST)
		public String ricercaPerIdRuolo(@PathVariable int idRuolo, Model model) {
			Ruolo rol = Dao.find(idRuolo);
			if(rol != null) {
				model.addAttribute("ruolo", rol);
				return "AggiornaRuolo";
			}
			else {
				return "ricercaRuoloKo";
			}
		}
		
		//@RequestMapping(value = "/{idRuolo}", method= RequestMethod.POST)
		//public void eliminaRuolo(@RequestBody int idRuolo) {
			
		    //Dao.delete(idRuolo);
		    
		    //System.out.println("Ruolo eliminato");
			
		//}
	
	

}
