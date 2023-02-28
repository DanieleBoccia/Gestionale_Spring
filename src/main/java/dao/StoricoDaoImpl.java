package dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Storico;

public class StoricoDaoImpl implements StoricoDaoInt {

	public Storico getAllStoricoById(int idStorico) throws SQLException{
		
		Connection dbConnection = null;
	    java.sql.PreparedStatement cmd = null;
	    Storico storico = null;

	    try {
	        String driver = "com.mysql.jdbc.Driver";

	        Class.forName(driver);

	        // Creiamo la stringa di connessione
	        String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	        // Otteniamo una connessione con username e password
	        dbConnection = DriverManager.getConnection(url, "root", "Bestbqre1_");

	        String selectSQL = "SELECT * FROM Storico WHERE idStorico = ?";

	        cmd = dbConnection.prepareStatement(selectSQL);

	        cmd.setInt(1, idStorico);

	        ResultSet rs = cmd.executeQuery();

	        if (rs.next()) {
	            int idRuolo = rs.getInt("idRuolo");
	            int matricola = rs.getInt("matricola");
	            Date dataInizio = rs.getDate("dataInizio");
	            Date dataFine = rs.getDate("dataFine");
	            int idStorico1 = rs.getInt("idStorico");
	            storico = new Storico(idStorico1, idRuolo, matricola, dataInizio, dataFine);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (cmd != null) {
	            cmd.close();
	        }

	        if (dbConnection != null) {
	            dbConnection.close();
	        }
	    }
	    return storico;
	}


	public void insertStorico(Storico s) throws SQLException{
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Bestbqre1_");

			String updateTableSQL = "INSERT INTO Storico(idStorico, idRuolo, matricola, dataInizio, dataFine) VALUES(?,?,?,?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, s.getIdStorico());
			cmd.setInt(2, s.getIdRuolo());
			cmd.setInt(3, s.getMatricola());
			cmd.setDate(4, new java.sql.Date(s.getDataInizio().getTime()));
			cmd.setDate(5, new java.sql.Date(s.getDataFine().getTime()));

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		} 
		}


	public void updateStorico(Storico s) throws SQLException{
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Bestbqre1_");

			String updateTableSQL = "UPDATE Storico SET idRuolo = ?, matricola = ?, dataInizio = ?, dataFine = ? WHERE idStorico = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, s.getIdRuolo());
			cmd.setInt(2, s.getMatricola());
			cmd.setDate(4, new java.sql.Date(s.getDataInizio().getTime()));
			cmd.setDate(5, new java.sql.Date(s.getDataFine().getTime()));
			cmd.setInt(5, s.getIdStorico());

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		} 
		}
		

	public void deleteStorico(Storico s) throws SQLException{
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Bestbqre1_");

			String updateTableSQL = "DELETE FROM Storico WHERE idStorico = ? AND idRuolo = ? matricola = ? dataInizio = ? dataFine = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, s.getIdStorico());
			cmd.setInt(2, s.getIdRuolo());
			cmd.setInt(3, s.getMatricola());
			cmd.setDate(4, new java.sql.Date(s.getDataInizio().getTime()));
			cmd.setDate(5, new java.sql.Date(s.getDataFine().getTime()));

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		} 
    }
}
