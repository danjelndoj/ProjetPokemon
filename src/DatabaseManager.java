import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsable de la connexion à la base de données.
 * Centralise l'ouverture et la fermeture de connexion.
 */
public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost/pokemon";
    private static final String USER = "root";
    private static final String PASSWORD = "linux";

    private Connection connection;

    
    public void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }

   Connection getConnection() {
        return connection;
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        try {
            dbManager.connect();
            System.out.println("Connexion réussie !");
            dbManager.disconnect();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }
}
