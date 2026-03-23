import java.util.Scanner;

public class Partie {
    public String nomJoueur;

    public void demanderPseudo() {
        Scanner nom = new Scanner (System.in);

        System.out.print("Saisissez votre pseudo : ");
        nomJoueur = nom.nextLine();

    }

    
}