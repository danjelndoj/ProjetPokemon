public class Attaque {
    public int puissance;
    public String nom;
    public int precision;
    public Type type;
    public int priorite;

    public Attaque(int puissance, int precision, String nom, Type type, int priorite) {
        this.puissance = puissance;
        this.precision = precision;
        this.nom = nom;
        this.type = type;
        this.priorite = priorite;
    }
}


