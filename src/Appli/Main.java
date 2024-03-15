package Appli;

import Jeu.Jeu;
import Jeu.Plateau;
import Jeu.Joueur;

import java.lang.*;

@SuppressWarnings("SpellCheckingInspection")
public class Main {
    public static void main(String[] args){
        boolean joueurCourant = true;
        Joueur Rouge = new Joueur('R',1,0);
        Joueur Blanc = new Joueur('W',1,1);
        Joueur Bleu = new Joueur('B',1,2);
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
            Joueur courant;
            if(joueurCourant) courant = Rouge;
            else courant = Bleu;
            Jeu.jouer(courant,plateau);
            System.out.println(Jeu.affichageScore(Rouge,Bleu));
            if(Jeu.EstFini(Rouge, Bleu)) break;
            courant = Blanc;
            Jeu.jouer(courant,plateau);
            joueurCourant = !joueurCourant;
        }
        System.out.println(Jeu.quiAGagne(Rouge,Bleu));
    }
}
