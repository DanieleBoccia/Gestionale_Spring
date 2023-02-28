package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.Impiegato;
import model.Ruolo;


public class client {

	public static void main(String[] args) throws SQLException {
		
		ImpDaoImpl dao = new ImpDaoImpl();
		Impiegato imp = new Impiegato("A", "ESPOSITO", "ESP1", 3000);
		Impiegato imp1 = new Impiegato("B", "ESPOSITO", "ESP2", 3001);
		Impiegato imp2 = new Impiegato("C", "ESPOSITO", "ESP3", 3002);
		Impiegato imp3 = new Impiegato("D", "ESPOSITO", "ESP4", 3003);
		Impiegato imp4 = new Impiegato("E", "ESPOSITO", "ESP5", 3004);
		Impiegato imp5 = new Impiegato("F", "ESPOSITO", "ESP6", 3005);
		Impiegato imp6 = new Impiegato("G", "ESPOSITO", "ESP7", 3006);
		Impiegato imp7 = new Impiegato("H", "ESPOSITO", "ESP8", 3007);
		Impiegato imp8 = new Impiegato("I", "ESPOSITO", "ESP9", 3008);
		Impiegato imp9 = new Impiegato("L", "ESPOSITO", "ESP10", 3009);
		
		try {
			dao.insertImpiegato(imp);
			dao.insertImpiegato(imp1);
			dao.insertImpiegato(imp2);
			dao.insertImpiegato(imp3);
			dao.insertImpiegato(imp4);
			dao.insertImpiegato(imp5);
			dao.insertImpiegato(imp6);
			dao.insertImpiegato(imp7);
			dao.insertImpiegato(imp8);
			dao.insertImpiegato(imp9);
		}catch(SQLException e) {
			e.printStackTrace();
		}

		
	}

}


