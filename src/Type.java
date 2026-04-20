import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

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

    public boolean isSameAs(PokemonInstance attacker) {
        return this.nom.equals(attacker.getType1().nom)
               || (attacker.getType2() != null && this.nom.equals(attacker.getType2().nom));
    }
}