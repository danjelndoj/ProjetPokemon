public class Joueur {
    protected String nom;
    protected Pokemon[] pokemon;
    protected int pokemonKO = 0;

    public Joueur(String nom, Pokemon[] pokemon,int pokemonKO){
        this.nom = nom;
        this.pokemon = pokemon;
        this.pokemonKO = pokemonKO;
}
    public String getNom(){
        return this.nom;
    }
    public Pokemon[] getPokemon(){
        return this.pokemon;
    }
    public int getpokemonKO(){
        return this.pokemonKO;
    }
} 
