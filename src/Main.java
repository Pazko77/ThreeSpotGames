import java.lang.*;
import java.util.Scanner;

@SuppressWarnings("SpellCheckingInspection")
public class Main {
    public static boolean joueurCourant;
    public static void main(String[] args){

        Joueurs Rouge = new Joueurs('R',1,0);
        Joueurs Blanc = new Joueurs('W',1,1);
        Joueurs Bleu = new Joueurs('B',1,2);
        Plateau plateau = new Plateau(3,3);
        plateau.ajouter(Rouge);
        plateau.ajouter(Bleu);
        plateau.ajouter(Blanc);
        System.out.println("Bienvenue sur le 3 Spots Game !");
        System.out.println();
        System.out.println("  - Le joueur B jouera la couleur bleue.");
        System.out.println("  - Le joueur R jouera la couleur rouge.");
        System.out.println();
        while (true){
            Joueurs courant;
            if(joueurCourant) courant = Rouge;
            else courant = Bleu;
            Jeu.jouer(courant,plateau);
            System.out.println(Jeu.affichageScore(Rouge,Bleu));
            if(Jeu.EstFini(Rouge, Bleu)) break;
            courant = Blanc;
            Jeu.jouer(courant,plateau);
            joueurCourant = !joueurCourant;
        }
        System.out.println(Jeu.aGagne(Rouge,Bleu));
    }
}
