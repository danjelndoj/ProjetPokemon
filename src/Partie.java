import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Partie {
    private final Scanner scanner = new Scanner(System.in);
    private Joueur joueur1;
    private Joueur joueur2;

    public void demarrer() {
        DatabaseManager dbm = new DatabaseManager();
        try {
            dbm.connect();
        } catch (SQLException e) {
            System.out.println("Erreur connexion : " + e.getMessage());
            return;
        }

        ArrayList<PokemonInstance> liste = new PokemonDAO(dbm).getTousLesPokemons();

        System.out.println("1 - Contre l'IA");
        System.out.println("2 - Contre un autre joueur");
        System.out.print("Votre choix : ");
        int modeJeu = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Saisissez votre pseudo : ");
        String nomJoueur1 = scanner.nextLine();
        joueur1 = new JoueurHumain(nomJoueur1, new PokemonInstance[6], 0);

        if (modeJeu == 1) {
            joueur2 = new JoueurIA(1, "Arène", "Ville", "IA", new PokemonInstance[6]);
            for (int i = 0; i < 6; i++) {
                joueur2.getPokemon()[i] = liste.get(i);
            }
        } else {
            System.out.print("Nom du joueur 2 : ");
            String nomJoueur2 = scanner.nextLine();
            joueur2 = new JoueurHumain(nomJoueur2, new PokemonInstance[6], 0);
        }

        System.out.println("=== " + joueur1.getNom() + " choisit ses pokémon ===");
        choisirPokemon(joueur1, liste);

        if (modeJeu == 2) {
            System.out.println("=== " + joueur2.getNom() + " choisit ses pokémon ===");
            choisirPokemon(joueur2, liste);
        }


        PokemonInstance pokemonActif1 = joueur1.getPokemon()[0];
        PokemonInstance pokemonActif2 = joueur2.getPokemon()[0];
        Combat combat = new Combat(joueur1, joueur2, pokemonActif1, pokemonActif2);
        combat.lancerCombat();
    }

   public void choisirPokemon(Joueur joueur, ArrayList<PokemonInstance> liste) {
    int nombrePokemon = 0;
    while (nombrePokemon < 6) {
        for (int i = 0; i < liste.size(); i++) {
            System.out.println(i + " : " + liste.get(i).getNom());
        }
        
        System.out.print("Choisissez un numéro (" + (nombrePokemon + 1) + "/6) : ");
        int choixPokemon = scanner.nextInt();
        scanner.nextLine();
        if (choixPokemon < 0 || choixPokemon >= liste.size()) {
            System.out.println("Numéro invalide, réessaie !");
            continue;
        }
       
        boolean dejaPris = false;
        PokemonInstance selection = liste.get(choixPokemon);
        for (int j = 0; j < nombrePokemon; j++) {
           
            if (joueur.getPokemon()[j].getNom().equals(selection.getNom())) {
                dejaPris = true;
                break;
            }
        }
        if (dejaPris) {
            System.out.println("Erreur : " + selection.getNom() + " est déjà dans ton équipe !");
            continue; 
        }
      
        joueur.getPokemon()[nombrePokemon] = PokemonInstance.depuis(selection);
        nombrePokemon++;
        System.out.println(selection.getNom() + " ajouté !");
    }
}

    public static void main(String[] args) {
        Partie partie = new Partie();
        partie.demarrer();
    }
}