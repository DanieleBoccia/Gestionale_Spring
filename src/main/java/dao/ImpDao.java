package dao;

import java.sql.SQLException;
import java.util.List;

import model.Impiegato;

public interface ImpDao {
	
	Impiegato getImpiegatoByCodiceFiscale(String codicefiscale) throws SQLException;
	List<Impiegato> getImpiegatoByCognome(String cognome) throws SQLException;
	void insertImpiegato(Impiegato i) throws SQLException;
	void updateImpiegato(Impiegato i) throws SQLException;
	void deleteImpiegato(int matricola) throws SQLException;
	

}
