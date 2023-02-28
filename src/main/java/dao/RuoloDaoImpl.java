package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Ruolo;

public class RuoloDaoImpl implements RuoloDaoInt {
	

	public Ruolo getAllRuoliById(int idRuolo) throws SQLException{
		Connection dbConnection = null;
	    java.sql.PreparedStatement cmd = null;
	    Ruolo ruolo = null;

	    try {
	        String driver = "com.mysql.jdbc.Driver";

	        Class.forName(driver);

	        // Creiamo la stringa di connessione
	        String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	        // Otteniamo una connessione con username e password
	        dbConnection = DriverManager.getConnection(url, "root", "Bestbqre1_");

	        String selectSQL = "SELECT * FROM Ruolo WHERE idRuolo = ?";

	        cmd = dbConnection.prepareStatement(selectSQL);

	        cmd.setInt(1, idRuolo);

	        ResultSet rs = cmd.executeQuery();

	        if (rs.next()) {
	            int idRuolo1 = rs.getInt("idRuolo");
	            String Descrizione = rs.getString("Descrizione");
	            ruolo = new Ruolo(idRuolo1, Descrizione);
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
	    return ruolo;
	}
	

	public void insertRuolo(Ruolo r) throws SQLException{
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Bestbqre1_");

			String updateTableSQL = "INSERT INTO Ruolo(idRuolo, Descrizione) VALUES(?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, r.getIdRuolo());
			cmd.setString(2, r.getDescrizione());

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

	public void updateRuolo(Ruolo r) throws SQLException{
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Bestbqre1_");

			String updateTableSQL = "UPDATE Ruolo SET Descrizione = ? WHERE idRuolo = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);
            
			cmd.setString(1, r.getDescrizione());
			cmd.setInt(2, r.getIdRuolo());

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

	public void deleteRuolo(Ruolo r) throws SQLException{
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Bestbqre1_");

			String updateTableSQL = "DELETE FROM Ruolo WHERE idRuolo = ? AND Descrizione = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, r.getIdRuolo());
			cmd.setString(2, r.getDescrizione());

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
