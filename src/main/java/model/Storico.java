package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Storico {
	public Storico() {}
	
	@Id
	private int idStorico;
	@ManyToOne
	@JoinColumn(name="idRuolo", referencedColumnName="idRuolo", insertable=false, updatable=false)
	private Ruolo ruolo;
	private int idRuolo;
	@ManyToOne
	@JoinColumn(name="matricola", referencedColumnName="matricola", insertable=false, updatable=false)
	private Impiegato impiegato;
	private int matricola;
	private Date dataInizio; 
	private Date dataFine = new Date();
	
	public Storico(int idStorico, int idRuolo, int matricola, Date dataInizio, Date dataFine){
		this.idStorico = idStorico;
		this.idRuolo = idRuolo;
		this.matricola = matricola;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public int getIdStorico() {
		return idStorico;
	}

	public void setIdStorico(int idStorico) {
		this.idStorico = idStorico;
	}

	public int getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	
	

}
