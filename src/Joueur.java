public class Joueur {
    private static final int NB_POKEMON = 6;

    protected String nom;
    protected Pokemon[] pokemon;
    protected int nbPokemonReel = 0;
    protected int pokemonKO = 0;

    public Joueur(String nom){
        this.nom=nom;
        this.pokemon = new Pokemon[NB_POKEMON];
    }

    public Joueur(String nom, Pokemon[] pokemon, int pokemonKO) {
        this(nom);
        this.pokemon = pokemon;
        this.nbPokemonReel = NB_POKEMON;
        this.pokemonKO = pokemonKO;
    }

    public String getNom() {
        return this.nom;
    }

    public Pokemon[] getPokemon() {
        return this.pokemon;
    }

    public int getpokemonKO() {
        return this.pokemonKO;
    }

    public void addPokemon(Pokemon p){
        if(this.nbPokemonReel >= NB_POKEMON){
            System.out.println("L'equipe est déjà au complet");
            return;
        }
        this.pokemon[nbPokemonReel] = p;
        this.nbPokemonReel++;
    }


    public void ajouterKO() {
        this.pokemonKO++;

    }
}
