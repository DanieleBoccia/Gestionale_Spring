package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ruolo {
	
	public Ruolo() {}
	
	
	@Id
	private int idRuolo;
	private String Descrizione;
	
	public Ruolo(int idRuolo, String Descrizione){
		this.idRuolo = idRuolo;
		this.Descrizione= Descrizione;
	}

	@Override
	public String toString() {
		return "Ruolo [idRuolo=" + idRuolo + ", Descrizione=" + Descrizione
				+ "]";
	}
	

	public int getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}

	public String getDescrizione() {
		return Descrizione;
	}

	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	
	}
	


