public class TypeManager {


    public static final Type COMBAT     = new Type("Combat");
    public static final Type DRAGON     = new Type("Dragon");
    public static final Type EAU        = new Type("Eau");
    public static final Type ELECTRIQUE = new Type("Electrique");
    public static final Type FEU        = new Type("Feu");
    public static final Type GLACE      = new Type("Glace");
    public static final Type INSECTE    = new Type("Insecte");
    public static final Type NORMAL     = new Type("Normal");
    public static final Type PLANTE     = new Type("Plante");
    public static final Type POISON     = new Type("Poison");
    public static final Type PSY        = new Type("Psy");
    public static final Type ROCHE      = new Type("Roche");
    public static final Type SOL        = new Type("Sol");
    public static final Type SPECTRE    = new Type("Spectre");
    public static final Type VOL        = new Type("Vol");

   
    private static final Type[][] BONUS = {
        {COMBAT, NORMAL}, {COMBAT, GLACE},  {COMBAT, ROCHE},
        {DRAGON, DRAGON},
        {EAU,    FEU},    {EAU,    ROCHE},  {EAU,    SOL},
        {ELECTRIQUE, EAU},{ELECTRIQUE, VOL},
        {FEU,    PLANTE}, {FEU,    GLACE},  {FEU,    INSECTE},
        {GLACE,  PLANTE}, {GLACE,  SOL},    {GLACE,  VOL},    {GLACE,  DRAGON},
        {INSECTE,PLANTE}, {INSECTE,POISON}, {INSECTE,PSY},
        {PLANTE, EAU},    {PLANTE, ROCHE},  {PLANTE, SOL},
        {POISON, PLANTE},
        {PSY,    COMBAT}, {PSY,    POISON},
        {ROCHE,  FEU},    {ROCHE,  GLACE},  {ROCHE,  INSECTE},{ROCHE, VOL},
        {SOL,    FEU},    {SOL,    ELECTRIQUE},{SOL,  POISON}, {SOL,   ROCHE},
        {SPECTRE,PSY},    {SPECTRE,SPECTRE},
        {VOL,    PLANTE}, {VOL,    COMBAT},  {VOL,    INSECTE}
    };

   
    private static final Type[][] PENALTY = {
        {COMBAT,     VOL},      {COMBAT,     PSY},
        {DRAGON,     DRAGON},
        {EAU,        PLANTE},   {EAU,        ELECTRIQUE},
        {ELECTRIQUE, SOL},
        {FEU,        EAU},      {FEU,        ROCHE},     {FEU,    SOL},
        {GLACE,      FEU},      {GLACE,      COMBAT},    {GLACE,  ROCHE},
        {INSECTE,    FEU},      {INSECTE,    VOL},       {INSECTE,ROCHE},
        {NORMAL,     COMBAT},
        {PLANTE,     FEU},      {PLANTE,     GLACE},     {PLANTE, INSECTE},
        {PLANTE,     POISON},   {PLANTE,     VOL},
        {POISON,     SOL},      {POISON,     PSY},
        {PSY,        INSECTE},  {PSY,        SPECTRE},
        {ROCHE,      EAU},      {ROCHE,      PLANTE},    {ROCHE,  COMBAT},  {ROCHE, SOL},
        {SOL,        EAU},      {SOL,        PLANTE},    {SOL,    GLACE},
        {SPECTRE,    SPECTRE},
        {VOL,        ELECTRIQUE},{VOL,       GLACE},     {VOL,    ROCHE}
    };


    public static boolean isBonus(Type attaquant, Type defenseur) {
        for (Type[] relation : BONUS) {
            if (relation[0].nom.equals(attaquant.nom)
                    && relation[1].nom.equals(defenseur.nom)) {
                return true;
            }
        }
        return false;
    }

    
    public static boolean isPenalty(Type attaquant, Type defenseur) {
        for (Type[] relation : PENALTY) {
            if (relation[0].nom.equals(attaquant.nom)
                    && relation[1].nom.equals(defenseur.nom)) {
                return true;
            }
        }
        return false;
    }

    public static Type getTypeByNom(String nom) {
        switch (nom) {
        case "Feu":
            return FEU;
        case "Eau":
            return EAU;
        case "Plante":
            return PLANTE;
        case "Electrique":
            return ELECTRIQUE;
        case "Normal":
            return NORMAL;
        case "Vol":
            return VOL;
        case "Poison":
            return POISON;
        case "Insecte":
            return INSECTE;
        case "Roche":
            return ROCHE;
        case "Sol":
            return SOL;
        case "Psy":
            return PSY;
        case "Combat":
            return COMBAT;
        case "Glace":
            return GLACE;
        case "Dragon":
            return DRAGON;
        case "Spectre":
            return SPECTRE;
        default:
            return null;
        }
    }
}