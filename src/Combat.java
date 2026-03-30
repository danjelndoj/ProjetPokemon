public class Combat {
    private Joueur joueur1;
    private Joueur joueur2;
    private Pokemon pokemonActif1;
    private Pokemon pokemonActif2;

    public Combat(Joueur joueur1, Joueur joueur2, Pokemon pokemonActif1, Pokemon pokemonActif2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.pokemonActif1 = pokemonActif1;
        this.pokemonActif2 = pokemonActif2;
    }

    private Joueur victoire() {
        if (joueur1.getpokemonKO() == 6)
            return joueur2;
        if (joueur2.getpokemonKO() == 6)
            return joueur1;
    }

    public Boolean finPartie(){
        if (joueur1.get.pokemoKO()== 6 || joueur2.get.pokemonKO()== 6){
            System.out.println("Le gagnant est " +
                this.victoire().getNom());
                return true;
        }
    }



    public int sauvegarder() {
        return 0;

    }

    public void charger(int numeroSauvegarde) {

    }

}
