package aula14.persistenciadeddos;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

	private static final String DRIVER = "org.sqlite.JDBC";
	private static final File dbFile = new File(".");
	private static final String URL = "jdbc:sqlite:" + dbFile.getAbsolutePath() + "/db/course.db";

	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL);
			System.out.println("Connection success");
			return con;
		} catch (Exception e) {
			System.out.println("Connection failed: " + e);
		}

		return con;
	}

	public static void closeConnection(Connection con) {

		try {
			if (con != null) {
				con.close();
				System.out.println("Connection closed");
			}
		} catch (Exception e) {
			throw new RuntimeException("Close connection failed");
		}
	}

	public static void closeConnection(Connection con, PreparedStatement st) {

		try {
			if (con != null) {
				con.close();
			}

			if (st != null) {
				st.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Close connection failed");
		}
	}

	public static void closeConnection(Connection con, PreparedStatement st, ResultSet rs) {

		try {
			if (con != null) {
				con.close();
			}

			if (st != null) {
				st.close();
			}

			if (rs != null) {
				rs.close();
			}

		} catch (Exception e) {
			throw new RuntimeException("Close connection failed");
		}
	}

}
