package cap06;

// Main
public class Program {

	public static void main(String[] args) {

		runV5();

	}
	
	/**
	 * Somente conecta, sem tratar exceptions.
	 */
	static void runV1(){
		Connection con = ConnectionFactory.getConnection();		
		con.getData();				
		ConnectionFactory.closeConnection(con);
	}
	
	/**
	 * Conecta e obrigatoriamente fecha a conexão.
	 */
	static void runV2() {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			con.getData();										
		} finally  {
			ConnectionFactory.closeConnection(con);
		}
	}
	
	/** 
	 * Conecta, fecha e trata a exceptions da maneira convencional.
	 */
	static void runV3() {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			con.getData();										
		} catch (UnExpectedException e){
			System.out.println(e.getMessage());
		} finally  {
			ConnectionFactory.closeConnection(con);
		}
	}
	
	/**
	 * Conecta e fecha com recursos.
	 */
	static void runV4() {
		try(Connection con = ConnectionFactory.getConnection()){
			con.getData();
		}
	}
	
	/**
	 * Conecta, trata e fecha com recursos.
	 */
	static void runV5() {
		try(Connection con = ConnectionFactory.getConnection()){
			con.getData();
		} catch (UnExpectedException e) {
			System.out.println(e.getMessage());
		}
	}	
}

// Connections
class ConnectionFactory {

	static Connection getConnection() {
		
		return new Connection();
	}
	
	static void closeConnection(Connection con) {
		
		con.close();
	}
}

class Connection implements AutoCloseable{
	
	Connection (){
		System.out.println("connection OPEN");
	}
	
	void getData(){
		System.out.println("getting DATA");
		throw new UnExpectedException("Falha ao recuperar dados.");
	}
	
	@Override
	public void close() {
		System.out.println("connection CLOSE");
	}
}

// Exceptions
class UnExpectedException extends RuntimeException {
	public UnExpectedException(String msg) {
		super(msg);
	}	
}

class ExpectedException extends Exception {}