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
        double multiplicateur = 1.0;

        
        if (attaque.type.isEfficient(adversaire.type1)) {
            multiplicateur = 2.0;
        }

       
        int degats = (int) ((this.attaque / (double) adversaire.defense) * attaque.puissance * multiplicateur);

        adversaire.recevoirDegats(degats);
        return degats;
    }

    public void recevoirDegats(int degats) {
        this.pv -= degats;
        if (this.pv < 0) {
            this.pv = 0;
        }
    }
}