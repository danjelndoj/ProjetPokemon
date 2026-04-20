public class PokemonInstance {
    private PokemonEspece espece;
    private int pvActuels;
    private Attaque[] attaques;
    private Etat etat;
    private int attaque;
    private int defense;
    private int vitesse;

    public PokemonInstance(PokemonEspece espece, Attaque[] attaques) {
        this.espece = espece;
        this.pvActuels = espece.getPvBase();
        this.attaque = espece.getAttaqueBase();
        this.defense = espece.getDefenseBase();
        this.vitesse = espece.getVitesseBase();
        this.attaques = attaques;
        this.etat = null;
    }

    public String getNom() {
        return this.espece.getNom();
    }
    public Type getType1() {
        return this.espece.getType1();
    }
    public Type getType2() {
        return this.espece.getType2();
    }
    public int getPv() {
        return this.pvActuels;
    }
    public int getAttaque() {
        return this.attaque;
    }
    public int getDefense() {
        return this.defense;
    }
    public int getVitesse() {
        return this.vitesse;
    }

    public static PokemonInstance depuis(PokemonInstance source) {
        return new PokemonInstance(source.espece, source.attaques);
    }
    public Attaque getAttaqueByIndex(int index) {
        return this.attaques[index];
    }
    public void recevoirDegats(int degats) {
        this.pvActuels -= degats;
        if (this.pvActuels < 0) {
            this.pvActuels = 0;
        }
    }
    public boolean estKO() {
        return this.pvActuels <= 0;
    }
    public void setPv(int pv) {
        this.pvActuels = pv;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public void setAttaque(int index, Attaque attaque) {
        this.attaques[index] = attaque;
    }
}
