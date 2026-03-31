import java.util.Scanner;

public class Partie {
    private Scanner scanner = new Scanner(System.in);
    private Joueur joueur1;
    private Joueur joueur2;



    public void demarrer() {
        System.out.println("1 - Contre l'IA");
        System.out.println("2 - Contre un autre joueur");
        System.out.print("Votre choix : ");
        int modeJeu = scanner.nextInt();
        scanner.nextLine();
        

    
        System.out.print("Saisissez votre pseudo : ");
        String nomJoueur1 = scanner.nextLine();
        joueur1 = new JoueurHumain(nomJoueur1, new Pokemon[6], 0 );

        
        if (modeJeu == 1) {
            joueur2 = new JoueurIA(new Pokemon[6]);
        } else {
            System.out.print("Nom du joueur 2 : ");
            String nomJoueur2 = scanner.nextLine();
            joueur2 = new JoueurHumain(nomJoueur2, new Pokemon[6]);
        }
    }

}
