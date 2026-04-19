class JoueurIA extends Joueur {
    private int arene;
    private String nomArene;
    private String nomVille;

    public JoueurIA(int arene, String nomArene, String nomVille, String nom, PokemonInstance[] pokemon) {
        this.arene = arene;
        this.nomArene = nomArene;
        this.nomVille = nomVille;
        this.nom = nom;
        this.pokemon = pokemon;
    }
}