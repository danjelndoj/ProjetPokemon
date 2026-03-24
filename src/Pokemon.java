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

    public Pokemon(String nom) {
        this.nom = nom;
        this.attaques = new Attaque[4];
    }

    public Attaque getAttaqueByIndex(int index) {
        if (index >= 0 && index < attaques.length) {
            return attaques[index];
        }
        return null;
    }

    public int attaquer(Attaque attaque, Pokemon adversaire) {

    }
}