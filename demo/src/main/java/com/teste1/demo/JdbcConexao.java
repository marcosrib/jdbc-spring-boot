package com.teste1.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class JdbcConexao {

	public void getConexao() {

		String url = "jdbc:oracle:thin:@172.31.37.203:1521:PRDMV";
		String user = "user_leitura";
		String password = "CoAgAuH4P&";
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		List<String> listLog = new ArrayList<>(); 
		
		for (int i = 0; i < 30; i++) {
		try {
			// Load the driver
			Class.forName("oracle.jdbc.OracleDriver");
			LocalDateTime incial = LocalDateTime.now();
			con = DriverManager.getConnection(url, user, password);

			stmt = con.createStatement();

			rs = stmt.executeQuery("SELECT CD_CONTRATO,\n" + "NM_SEGURADO, \n" + "CD_MATRICULA, \n" + "CD_MATRICULA, \n"
					+ "CD_MATRICULA \n" + "FROM dbaps.usuario WHERE ROWNUM  <= 10");
		

			// Print all of the employee numbers to standard output device
			while (rs.next()) {
				/*String	empNo = rs.getString(1);
				String	empN1  = rs.getString(2);
				String	empN2  = rs.getString(3);*/
				/*System.out.println("Employee number = " + empNo);*/
			}

			// Close the ResultSet
			rs.close();
			stmt.close();
			con.close();
			LocalDateTime finaldd = LocalDateTime.now();

			long seconds = ChronoUnit.SECONDS.between(incial, finaldd);
			long milliseconds = ChronoUnit.MILLIS.between(incial, finaldd);
	
		

			String log = "Segundos: " + seconds + " miliseundos: " + milliseconds;
			listLog.add(log);

		} catch (ClassNotFoundException e) {
			System.err.println("Could not load JDBC driver");
			System.out.println("Exception: " + e);
			e.printStackTrace();
		}

		catch (SQLException ex) {
			System.err.println("SQLException information");
			while (ex != null) {
				System.err.println("Error msg: " + ex.getMessage());
				System.err.println("SQLSTATE: " + ex.getSQLState());
				System.err.println("Error code: " + ex.getErrorCode());
				ex.printStackTrace();
				ex = ex.getNextException(); // For drivers that support chained exceptions
			}
		}
	} // End
	
		new SalvarArquivo().createFile(listLog, "logs" + LocalDateTime.now());
	}
}
