import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PokemonDAO {
DatabaseManager dbm = new DatabaseManager();

    public void afficherPokemons() {
        try {
            dbm.connect();
            System.out.println("Connexion réussie");

            String sql = "SELECT * FROM pokemons";
            PreparedStatement requete = dbm.getConnection().prepareStatement(sql);
            ResultSet donnees = requete.executeQuery();

            while (donnees.next()) {
                System.out.println(
                    donnees.getInt("id") + " : " + donnees.getString("nom")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}