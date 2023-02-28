package dao;

import java.sql.SQLException;

import model.Ruolo;

public interface RuoloDaoInt {
	
	Ruolo getAllRuoliById(int idRuolo)throws SQLException;
	void insertRuolo(Ruolo r)throws SQLException;
	void updateRuolo(Ruolo r)throws SQLException;
	void deleteRuolo(Ruolo r)throws SQLException;
	

}
