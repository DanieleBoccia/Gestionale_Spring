package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Impiegato;

public class ImpDaoImpl implements ImpDao {

		public Impiegato getImpiegatoByCodiceFiscale(String codicefiscale) throws SQLException {
		    Connection dbConnection = null;
		    java.sql.PreparedStatement cmd = null;
		    Impiegato impiegato = null;

		    try {
		        String driver = "com.mysql.jdbc.Driver";

		        Class.forName(driver);

		        // Creiamo la stringa di connessione
		        String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		        // Otteniamo una connessione con username e password
		        dbConnection = DriverManager.getConnection(url, "root", "Bestbqre1_");

		        String selectSQL = "SELECT * FROM Impiegato WHERE codicefiscale = ?";

		        cmd = dbConnection.prepareStatement(selectSQL);

		        cmd.setString(1, codicefiscale);

		        ResultSet rs = cmd.executeQuery();

		        if (rs.next()) {
		            String nome = rs.getString("nome");
		            String cognome = rs.getString("cognome");
		            int matricola = rs.getInt("matricola");
		            impiegato = new Impiegato(nome, cognome, codicefiscale, matricola);
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
		    return impiegato;
		}

	

	public void insertImpiegato(Impiegato i) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Bestbqre1_");

			String updateTableSQL = "INSERT INTO Impiegato(nome, cognome, codicefiscale, matricola) VALUES(?,?,?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, i.getNome());
			cmd.setString(2, i.getCognome());
			cmd.setString(3, i.getCodicefiscale());
			cmd.setInt(4, i.getMatricola());

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

	public void updateImpiegato(Impiegato i) throws SQLException{
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Bestbqre1_");

			String updateTableSQL = "UPDATE Impiegato SET nome = ?, cognome = ?, matricola = ? WHERE codicefiscale = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, i.getNome());
			cmd.setString(2, i.getCognome());
			cmd.setInt(3, i.getMatricola());
			cmd.setString(4, i.getCodicefiscale());

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

	public void deleteImpiegato(int matricola) throws SQLException{
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "Bestbqre1_");

			String updateTableSQL = "DELETE FROM Impiegato WHERE matricola = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, matricola);

			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is deleted DBUSER table!");

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
	public List<Impiegato> getImpiegatoByCognome(String cognome) throws SQLException {
	    Connection dbConnection = null;
	    java.sql.PreparedStatement cmd = null;
	    List<Impiegato> impiegati = new ArrayList<Impiegato>();

	    try {
	        String driver = "com.mysql.jdbc.Driver";

	        Class.forName(driver);

	        // Creiamo la stringa di connessione
	        String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	        // Otteniamo una connessione con username e password
	        dbConnection = DriverManager.getConnection(url, "root", "Bestbqre1_");

	        String selectSQL = "SELECT * FROM Impiegato WHERE cognome LIKE ?";

	        cmd = dbConnection.prepareStatement(selectSQL);

	        cmd.setString(1, "%" + cognome + "%");

	        ResultSet rs = cmd.executeQuery();

	        while (rs.next()) {

	            String nome = rs.getString("nome");
	            String codicefiscale = rs.getString("codicefiscale");
	            int matricola = rs.getInt("matricola");
	            String cognome1 = rs.getString("cognome");
	            impiegati.add(new Impiegato(nome, cognome1, codicefiscale, matricola));
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
	    return impiegati;
	}
   
}
