
class JoueurHumain extends Joueur {
    protected int nbBadge = 0;
    protected Boolean[] badges;
    protected int nbVictoire = 0;

    public JoueurHumain(String nom, PokemonInstance[] pokemons, int pokemonKO) {
        this.nom = nom;
        this.pokemon = pokemons;
        this.pokemonKO = pokemonKO;
    }

}
