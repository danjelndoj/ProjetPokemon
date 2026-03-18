public class Type {

    // Seulement ce qui est dans le UML
    public String nom;

    public Type(String nom) {
        this.nom = nom;
    }

    public boolean havePenaltyVs(Type typeAdverse) {
        return TypeManager.isPenalty(this, typeAdverse);
    }

    public boolean haveBonusVs(Type typeAdverse) {
        return TypeManager.isBonus(this, typeAdverse);
    }

    public boolean isEfficient(Type typeAdverse) {
        return !havePenaltyVs(typeAdverse) && !haveBonusVs(typeAdverse);
    }

    public boolean is

    public boolean isSameAs(Pokemon attacker) {
        return this.nom.equals(attacker.type1.nom)
            || (attacker.type2 != null && this.nom.equals(attacker.type2.nom));
    }
}