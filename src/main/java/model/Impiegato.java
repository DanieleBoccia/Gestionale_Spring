//creazione pacchetto
package model;

import javax.persistence.Entity;
import javax.persistence.Id;

//creazione classe, un prototipo di impiegato con i suoi attributi e le sue caratteristiche
@Entity
public class Impiegato {
	public Impiegato() {}
	
	
	private String nome;
	private String cognome;
	private String codicefiscale;
	@Id
	private int matricola;
	
	//metodo costruttore per poter accedere alle variabili private (attributi)
	public Impiegato(String nome, String cognome, String codicefiscale, int matricola){
		this.nome = nome;
		this.cognome = cognome;
		this.codicefiscale = codicefiscale;
		this.matricola = matricola;
	}
	
	@Override
	public String toString() {
		return "Impiegato [nome=" + nome + ", cognome=" + cognome
				+ ", codicefiscale=" + codicefiscale + ", matricola="
				+ matricola + "]";
	}

	//metodi get e set per poter richiamare e svolgere operazioni logiche con le variabili private
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodicefiscale() {
		return codicefiscale;
	}
	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	
	

}