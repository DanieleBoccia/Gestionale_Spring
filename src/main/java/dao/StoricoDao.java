package dao;

import java.util.ArrayList;

import model.Storico;

public class StoricoDao {

	ArrayList<Storico> listaStorico;
	
	public Storico ricercaPerIdStorico(int idStorico){
		for(Storico str : listaStorico){
			if(str.getIdStorico()==idStorico){
				return str;
			}
		}
		return null;
	}
	
	public void inserisci(Storico i){
		listaStorico.add(i);
	}
	
	public boolean aggiorna(Storico i){
		for(Storico str : listaStorico){
			if(str.getIdStorico() == i.getIdStorico()){
				str.setIdRuolo(i.getIdRuolo());
	            str.setMatricola(i.getMatricola());
	            str.setDataInizio(i.getDataInizio());
	            str.setDataFine(i.getDataFine());
				return true;
				}
		}
		return false;
	}
	
	public boolean elimina(int idStorico){
		for(Storico str : listaStorico){
			if(str.getIdStorico()==idStorico){
				listaStorico.remove(str);
				return true;
			}
		}
		return false;
	}
	
	
}
