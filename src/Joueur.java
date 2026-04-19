public class Joueur {
    protected String nom;
    protected PokemonInstance[] pokemon;
    protected int pokemonKO = 0;

    public Joueur(String nom, PokemonInstance[] pokemon, int pokemonKO) {
        this.nom = nom;
        this.pokemon = pokemon;
        this.pokemonKO = pokemonKO;
    }

    public String getNom() {
        return this.nom;
    }

    public PokemonInstance[] getPokemon() {
        return this.pokemon;
    }

    public int getpokemonKO() {
        return this.pokemonKO;
    }

    public Joueur() {

    }

    public void ajouterKO() {
        this.pokemonKO++;

    }
}
