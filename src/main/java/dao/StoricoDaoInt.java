package dao;

import java.sql.SQLException;

import model.Storico;

public interface StoricoDaoInt {
	
	Storico getAllStoricoById(int idStorico)throws SQLException;
	void insertStorico(Storico s)throws SQLException;
	void updateStorico(Storico s)throws SQLException;
	void deleteStorico(Storico s)throws SQLException;

}
