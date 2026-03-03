import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsable de la connexion à la base de données.
 * Centralise l'ouverture et la fermeture de connexion.
 */
public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost/pokemon"; //A modifier
    private static final String USER = "userdb"; // A modifier
    private static final String PASSWORD = "linux"; // A modifier

    private Connection connection;

    /**
     * Ouvre la connexion à la base.
     */
    public void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }

    /**
     * Retourne la connexion active.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Ferme la connexion.
     */
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
