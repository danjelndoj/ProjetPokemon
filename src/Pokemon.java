public class Pokemon {
    private String nom;
    private int pvMax;
    private int pv;
    private int attaque;
    private int defense;
    private int vitesse;
    private Type type1;
    private Type type2;
    private Attaque[] attaques;
    private Etat etat;

    public Pokemon(String nom, Type type1, Type type2) {
        this.nom = nom;
        this.attaques = new Attaque[4];
        this.type1 = type1;
        this.type2 = type2;
    }

    public Type getType1() {
        return type1;
    }

    public Type getType2() {
        return type2;
    }

    public String getNom() {
        return nom;
    }
    

    public Attaque getAttaqueByIndex(int index) {
        if (index >= 0 && index < attaques.length) {
            return attaques[index];
        }
        return null;
    }

    public int getPv() {
        return this.pv;
    }

}