public class PokemonEspece {
    private String nom;
    private int pvBase;
    private int attaqueBase;
    private int defenseBase;
    private int vitesseBase;
    private Type type1;
    private Type type2;


    public PokemonEspece(String nom, int pvBase, int attaqueBase, int defenseBase, int vitesseBase, Type type1, Type type2) {
        this.nom = nom;
        this.pvBase = pvBase;
        this.attaqueBase = attaqueBase;
        this.defenseBase = defenseBase;
        this.vitesseBase = vitesseBase;
        this.type1 = type1;
        this.type2 = type2;
    }

   
    public String getNom() {
        return nom;
    }
    public int getPvBase() {
        return pvBase;
    }
    public int getAttaqueBase() {
        return attaqueBase;
    }
    public int getDefenseBase() {
        return defenseBase;
    }
    public int getVitesseBase() {
        return vitesseBase;
    }
    public Type getType1() {
        return type1;
    }
    public Type getType2() {
        return type2;
    }
}