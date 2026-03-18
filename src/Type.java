public class Type {

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

    public boolean isSameAs(Pokemon attacker) {
        return this.nom.equals(attacker.getType1().nom)
                || (attacker.getType1() != null && this.nom.equals(attacker.getType2().nom));
    }
}