import java.util.LinkedList;
import java.util.stream.Stream;

@SuppressWarnings("SpellCheckingInspection")

public class Jeu {

    /**
     * @brief Incremente le score d'un joueur si ses pions se trouve sur x = 2
     * @param j Joueurs
     * @param pions Tableau des pions
     */
    public static void score(Joueurs j, LinkedList<Pion> pions){

        for ( Pion e : pions){
            if(j.getCouleur() == e.getId() && e.getX() == 2){ //on ne vérifie que l'axe x
                j.setScore(1);
                // 1er spot x=2 et y = 0
                // 2e spot x=2 et y = 1
                // 3e spot x=2 et y = 2
            }
        }
    }

    /**
     * @brief vérifie si l'écart de point entre les joueurs 1 et 2 et supérieurs ou inférieur à 6
     * @param j1 Joueurs 1
     * @param j2 Joueurs 2
     * @return Si scoreJ1- scoreJ2 >= 6,renvoie vrai sinon faux
     */
    public static boolean comparerScore(Joueurs j1, Joueurs j2){

        int scoreJ1 = j1.getScore(), scoreJ2 = j2.getScore();
        if(scoreJ1 > scoreJ2)
            return (scoreJ1-scoreJ2) <= 6;
        else
            return (scoreJ2-scoreJ1) <= 6;
    }

    /**
     * @brief détermine le gagnant entre les joueurs 1 et 2
     * @param j1 Joueurs 1
     * @param j2 Joueurs 2
     * @return Renvoie un String avec la couleur du joueurs gagnant
     */
    public static String aGagne(Joueurs j1, Joueurs j2){
        StringBuilder sb = new StringBuilder();
        sb.append("Le joueur ");
        sb.append(comparerScore(j1,j2) ? j1.getCouleur() : j2.getCouleur());
        sb.append(" à Gagner\n");
        return sb.toString();
    }

    /**
     * @brief détermine si la partie est fini
     * @param j1 Joueurs 1
     * @param j2 Joueurs 2
     * @return si un des deux joueurs atteint le score 12 renvoie vrai
     */
    public static boolean EstFini(Joueurs j1 ,Joueurs j2){
        return j1.getScore() >= 12 || j2.getScore() >= 12;
    }

    public static String affichageScore(Joueurs j1, Joueurs j2){
        StringBuilder sb = new StringBuilder();
        sb.append(j1.getCouleur());
        sb.append(" ");
        sb.append(j1.getScore());
        sb.append("-");
        sb.append(j2.getScore());
        sb.append(" ");
        sb.append(j2.getCouleur());
        return sb.toString();
    }
}
