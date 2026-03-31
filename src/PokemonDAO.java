import java.util.ArrayList;
import java.sql.Connection;
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

    public double recupMulti(int fkAtt, int fkDef) {
        String sql = "SELECT multi FROM efficacite WHERE fkAtt = ? AND fkDef = ? LIMIT 1";

        try {
            PreparedStatement pstmt = dbm.getConnection().prepareStatement(sql);
            pstmt.setInt(1, fkAtt);
            pstmt.setInt(2, fkDef);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble("multi");
            }

        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        return 0.0;
    }
}
