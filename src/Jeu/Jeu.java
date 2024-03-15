package Jeu;

import java.util.LinkedList;
import java.util.Scanner;

@SuppressWarnings("SpellCheckingInspection")

public class Jeu {

    /**
     * @brief Incremente le score d'un joueur si ses pions se trouve sur x = 2
     * @param joueur Joueur
     * @param pions Tableau des pions
     */
    public static void score(Joueur joueur, LinkedList<Pion> pions){

        for ( Pion e : pions){
            if(joueur.getCouleur() == e.getId() && e.getX() == 2){ //on ne vérifie que l'axe x
                joueur.setScore(1);
                // 1er spot x=2 et y = 0
                // 2e spot x=2 et y = 1
                // 3e spot x=2 et y = 2
            }
        }
    }

    /**
     * @brief vérifie si l'écart de point entre les joueurs 1 et 2 et supérieurs ou inférieur à 6
     * @param joueur1 Joueur 1
     * @param joueur2 Joueur 2
     * @return Si scoreJ1- scoreJ2 >= 6,renvoie vrai sinon faux
     */
    public static char comparerScore(Joueur joueur1, Joueur joueur2) {

        int scoreJ1 = joueur1.getScore(), scoreJ2 = joueur2.getScore();
        if (scoreJ1 > scoreJ2){
            if ((scoreJ1 - scoreJ2) <= 6)
                return joueur1.getCouleur();
            else
                return joueur2.getCouleur();
        }else{
            if((scoreJ2-scoreJ1) <= 6)
                return joueur2.getCouleur();
            else
                return joueur1.getCouleur();
        }
    }

    /**
     * @brief détermine le gagnant entre les joueurs 1 et 2
     * @param joueur1 Joueurs 1
     * @param joueur2 Joueurs 2
     * @return Renvoie un String avec la couleur du joueurs gagnant
     */
    public static String quiAGagne(Joueur joueur1, Joueur joueur2){
        return "Le joueur " + comparerScore(joueur1, joueur2) + " à Gagner\n";
    }

    /**
     * @brief détermine si la partie est fini
     * @param joueur1 Joueurs 1
     * @param joueur2 Joueurs 2
     * @return si un des deux joueurs atteint le score 12 renvoie vrai
     */
    public static boolean EstFini(Joueur joueur1 , Joueur joueur2){
        return joueur1.getScore() >= 12 || joueur2.getScore() >= 12;
    }

    public static String affichageScore(Joueur joueur1, Joueur joueur2){
        return joueur1.getCouleur() + " " + joueur1.getScore() + " - " + joueur2.getScore() + " " + joueur2.getCouleur();
    }

    /**
     *
     * @param joueur Joueur courant
     * @param plateau Le plateau de jeu
     */
    public static void jouer(Joueur joueur, Plateau plateau){
        Scanner sc = new Scanner(System.in);
        boolean pionBlanc = joueur.getCouleur() == 'W';
        plateau.positionNonOccuper();
        plateau.supprimer(joueur);
        System.out.println(plateau.toStringBefore());
        plateau.ajouter(joueur);
        if(!pionBlanc)
            System.out.println("Joueur "+joueur.getCouleur()+" à vous de jouez :");
        else
            System.out.println("Jouez le pion neutre "+joueur.getCouleur()+" : ");

        int pos1 = 0 ,pos2 = 0;
        while(!plateau.saisieDeplacementCorrect(pos1,pos2)) {
            System.out.println("Saississez deux position différente voisine disponible sur le plateau :");
            pos1 = sc.nextInt();pos2 = sc.nextInt();
            plateau.deplacement(joueur, pos1, pos2);
        }
        if(!pionBlanc) Jeu.score(joueur,plateau.getPions());
        System.out.println(plateau.toStringAfter());
        plateau.clearPositionVide();
    }
}
