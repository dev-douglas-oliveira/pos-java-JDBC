package conexaoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String url = "jdbc:postgresql://localhost:5432/posjava";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;

	static {
		conectar(); // qualquer lugar que eu invocar o SingleConnection, ele vai chamar o conectar
					// ()
	}

	public SingleConnection() {
		conectar();
	}

	private static void conectar() {
		try {
			if (connection == null) {
				// iniciar carregamento do driver de conexão que iremos usar
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false); //falso para que decidir quando salvar as operações do banco
				System.out.println("Conexao estabelecida com sucesso");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		return connection;
	}

}
