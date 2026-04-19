
```
1 - Contre l'IA
2 - Contre un autre joueur
Votre choix :
```

- Chaque joueur choisit **6 Pokémon** parmi ceux disponibles en base.
- Le combat se déroule tour par tour jusqu'à ce que tous les Pokémon d'un joueur soient KO.


javac -cp .:../lib/mysql-connector-j-8.3.0.jar *.java
java -cp .:../lib/mysql-connector-j-8.3.0.jar Partie

## Structure des fichiers

| Fichier              | Rôle                                              |
|----------------------|---------------------------------------------------|
| `Partie.java`        | Point d'entrée, gestion du menu et sélection      |
| `Combat.java`        | Boucle de combat tour par tour                    |
| `Joueur.java`        | Classe de base joueur                             |
| `JoueurHumain.java`  | Extension : badges, victoires                     |
| `JoueurIA.java`      | Extension : arène, ville                          |
| `PokemonInstance.java` | Pokémon en combat (PV actuels, état)            |
| `PokemonEspece.java` | Données de base (stats, types)                    |
| `Attaque.java`       | Attaque (puissance, précision, type)              |
| `Type.java`          | Type avec calcul bonus/malus                      |
| `TypeManager.java`   | Table de toutes les relations de types            |
| `PokemonDAO.java`    | Accès base de données (chargement des Pokémon)    |
| `DatabaseManager.java` | Connexion/déconnexion JDBC                      |
| `Etat.java`          | Classe Etat          |
| `Test.java`          | Script de test de connexion SQL                   |
