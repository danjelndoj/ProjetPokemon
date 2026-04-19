import java.sql.*;
import java.util.ArrayList;

public class PokemonDAO {
    private DatabaseManager dbm;

    public PokemonDAO(DatabaseManager dbm) {
        this.dbm = dbm;
    }

    public ArrayList<PokemonInstance> getTousLesPokemons() {
        ArrayList<PokemonInstance> listePokemon = new ArrayList<>();

        String sqlPokemons =
            "SELECT pokemons.id, pokemons.nom, pokemons.pv, pokemons.attaque, " +
            "pokemons.defense, pokemons.vitesse " +
            "FROM pokemons";

        String sqlTypes =
            "SELECT types.libelle " +
            "FROM types " +
            "JOIN est_type ON types.id = est_type.type_id " +
            "WHERE est_type.pokemon_id = ?";

        String sqlAttaques =
            "SELECT attaques.libelle, attaques.puissance, attaques.precis, types.libelle AS type_libelle " +
            "FROM attaques " +
            "JOIN types ON attaques.type_id = types.id " +
            "WHERE attaques.puissance IS NOT NULL " +
            "AND attaques.type_id IN (" +
            "    SELECT est_type.type_id FROM est_type WHERE est_type.pokemon_id = ?" +
            ") " +
            "ORDER BY RAND() LIMIT 4";

        try {
            PreparedStatement reqPokemons = dbm.getConnection().prepareStatement(sqlPokemons);
            ResultSet resultPokemons = reqPokemons.executeQuery();

            PreparedStatement reqTypes = dbm.getConnection().prepareStatement(sqlTypes);
            PreparedStatement reqAttaques = dbm.getConnection().prepareStatement(sqlAttaques);

            while (resultPokemons.next()) {
                int pokemonId = resultPokemons.getInt("id");
                String pokemonNom = resultPokemons.getString("nom");
                int pv = resultPokemons.getInt("pv");
                int attaque = resultPokemons.getInt("attaque");
                int defense = resultPokemons.getInt("defense");
                int vitesse = resultPokemons.getInt("vitesse");

                // Récupération des types
                reqTypes.setInt(1, pokemonId);
                ResultSet resultTypes = reqTypes.executeQuery();

                Type type1 = null;
                Type type2 = null;

                if (resultTypes.next()) {
                    type1 = TypeManager.getTypeByNom(resultTypes.getString("libelle"));
                }
                if (resultTypes.next()) {
                    type2 = TypeManager.getTypeByNom(resultTypes.getString("libelle"));
                }

                resultTypes.close();

                PokemonEspece pokemon = new PokemonEspece(pokemonNom, pv, attaque, defense, vitesse, type1, type2);


                reqAttaques.setInt(1, pokemonId);
                ResultSet resultAttaques = reqAttaques.executeQuery();

                Attaque[] attaques = new Attaque[4];

                int indexAttaque = 0;
                while (resultAttaques.next() && indexAttaque <4) {
                    Type typeAttaque = TypeManager.getTypeByNom(resultAttaques.getString("type_libelle"));
                    Attaque a = new Attaque(
                        resultAttaques.getInt("puissance"),
                        resultAttaques.getInt("precis"),
                        resultAttaques.getString("libelle"),
                        typeAttaque,
                        0
                    );
                    attaques[indexAttaque] = a ;
                    indexAttaque++;

                }
                resultAttaques.close();
                listePokemon.add(new PokemonInstance (pokemon,attaques));
            }

            reqPokemons.close();
            reqTypes.close();
            reqAttaques.close();

        } catch (SQLException e) {
            System.out.println("Erreur SQL dans getTousLesPokemons : " + e.getMessage());
        }

        return listePokemon;
    }
}