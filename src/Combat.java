import java.util.Scanner;
public class Combat {
    private Joueur joueur1;
    private Joueur joueur2;
    private PokemonInstance pokemonActif1;
    private PokemonInstance pokemonActif2;
    public Combat(Joueur joueur1, Joueur joueur2, PokemonInstance pokemonActif1, PokemonInstance pokemonActif2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.pokemonActif1 = pokemonActif1;
        this.pokemonActif2 = pokemonActif2;
    }
    private Joueur victoire() {
        if (joueur1.getpokemonKO() == 6) return joueur2;
        if (joueur2.getpokemonKO() == 6) return joueur1;
        return null;
    }
    public Boolean finPartie() {
        if (joueur1.getpokemonKO() == 6 || joueur2.getpokemonKO() == 6) {
            System.out.println("Le gagnant est " + this.victoire().getNom());
            return true;
        }
        return false;
    }
    public void lancerCombat() {
        Scanner scanner = new Scanner(System.in);
        int indexPokemon1 = 0;
        int indexPokemon2 = 0;
        while (victoire() == null) {
            if (pokemonActif1.estKO()) {
                indexPokemon1++;
                if (indexPokemon1 < joueur1.getPokemon().length && joueur1.getPokemon()[indexPokemon1] != null) {
                    pokemonActif1 = joueur1.getPokemon()[indexPokemon1];
                    System.out.println("Votre prochain pokémon : " + pokemonActif1.getNom());
                }
            }
            if (pokemonActif2.estKO()) {
                indexPokemon2++;
                if (indexPokemon2 < joueur2.getPokemon().length && joueur2.getPokemon()[indexPokemon2] != null) {
                    pokemonActif2 = joueur2.getPokemon()[indexPokemon2];
                    System.out.println("Le prochain pokémon adverse est : " + pokemonActif2.getNom());
                }
            }
            System.out.println("Votre pokémon : " + pokemonActif1.getNom() + " PV : " + pokemonActif1.getPv());
            System.out.println("Pokémon adverse : " + pokemonActif2.getNom() + " PV : " + pokemonActif2.getPv());
            System.out.println("Choisissez une attaque :");
            for (int i = 0; i < 4; i++) {
                Attaque a = pokemonActif1.getAttaqueByIndex(i);
                if (a != null) {
                    System.out.println(i + " : " + a.nom + " (puissance : " + a.puissance + ")");
                }
            }
            int choix = scanner.nextInt();
            scanner.nextLine();
            Attaque attaqueChoisie = pokemonActif1.getAttaqueByIndex(choix);
            if (attaqueChoisie == null) {
                System.out.println("Attaque n'existe pas!");
                continue;
            }
            double multiplicateur = 1.0;
            if (attaqueChoisie.type.haveBonusVs(pokemonActif2.getType1())) {
                multiplicateur *= 2.0;
            } else if (attaqueChoisie.type.havePenaltyVs(pokemonActif2.getType1())) {
                multiplicateur *= 0.5;
            }
            if (pokemonActif2.getType2() != null) {
                if (attaqueChoisie.type.haveBonusVs(pokemonActif2.getType2())) {
                    multiplicateur *= 2.0;
                } else if (attaqueChoisie.type.havePenaltyVs(pokemonActif2.getType2())) {
                    multiplicateur *= 0.5;
                }
            }
            if (multiplicateur > 1.0) {
                System.out.println("C'est super efficace !");
            } else if (multiplicateur < 1.0 && multiplicateur > 0) {
                System.out.println("Ce n'est pas très efficace...");
            } else if (multiplicateur == 0) {
                System.out.println("Ça n'a aucun effet...");
            }
            int degats = (int) ((pokemonActif1.getAttaque() / (double) pokemonActif2.getDefense()) * attaqueChoisie.puissance * multiplicateur);
            pokemonActif2.recevoirDegats(degats);
            System.out.println(pokemonActif1.getNom() + " utilise " + attaqueChoisie.nom + " et inflige " + degats + " dégâts !");
            if (pokemonActif2.estKO()) {
                joueur2.ajouterKO();
                System.out.println(pokemonActif2.getNom() + " est KO !");
            }
            
            if (victoire() == null && !pokemonActif2.estKO()) {
                int attaqueIA = (int) (Math.random() * 4);
                Attaque attaqueChoisieIA = pokemonActif2.getAttaqueByIndex(attaqueIA);
                if (attaqueChoisieIA != null) {
                    double multiplicateurIA = 1.0;
                    if (attaqueChoisieIA.type.haveBonusVs(pokemonActif1.getType1())) {
                        multiplicateurIA *= 2.0;
                    } else if (attaqueChoisieIA.type.havePenaltyVs(pokemonActif1.getType1())) {
                        multiplicateurIA *= 0.5;
                    }
                    if (pokemonActif1.getType2() != null) {
                        if (attaqueChoisieIA.type.haveBonusVs(pokemonActif1.getType2())) {
                            multiplicateurIA *= 2.0;
                        } else if (attaqueChoisieIA.type.havePenaltyVs(pokemonActif1.getType2())) {
                            multiplicateurIA *= 0.5;
                        }
                    }
                    if (multiplicateurIA > 1.0) {
                        System.out.println("C'est super efficace !");
                    } else if (multiplicateurIA < 1.0) {
                        System.out.println("Ce n'est pas très efficace...");
                    }
                    int degatsIA = (int) ((pokemonActif2.getAttaque() / (double) pokemonActif1.getDefense()) * attaqueChoisieIA.puissance * multiplicateurIA);
                    pokemonActif1.recevoirDegats(degatsIA);
                    System.out.println(pokemonActif2.getNom() + " utilise " + attaqueChoisieIA.nom + " et inflige " + degatsIA + " dégâts !");
                    if (pokemonActif1.estKO()) {
                        joueur1.ajouterKO();
                        System.out.println(pokemonActif1.getNom() + " est KO !");
                    }
                }
            }
        }
        finPartie();
    }
}