package dao;

import java.util.ArrayList;

import model.Ruolo;

public class RuoloDao {
	
	ArrayList<Ruolo> listaRuoli;
	
	public Ruolo ricercaPerIdRuolo(int idRuolo){
		for(Ruolo rol : listaRuoli){
			if(rol.getIdRuolo()==idRuolo){
				return rol;
			}
		}
		return null;
	}
	
	
	public void inserisci(Ruolo i){
		listaRuoli.add(i);
	}
	
	
	public boolean aggiorna(Ruolo i){
		for(Ruolo rol : listaRuoli){
			if(rol.getIdRuolo() == i.getIdRuolo()){
				rol.setDescrizione(i.getDescrizione());
				return true;
				}
		}
		return false;
	}
	
	public boolean elimina(int idRuolo){
		for(Ruolo rol : listaRuoli){
			if(rol.getIdRuolo() == idRuolo){
				listaRuoli.remove(rol);
				return true;
			}
		}
		return false;
	}
	
	
}
