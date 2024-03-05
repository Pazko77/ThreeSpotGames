import java.util.LinkedList;
@SuppressWarnings("SpellCheckingInspection")
public class Jeu {

    public void score(Joueurs j, LinkedList<Pion> pions){

        for ( Pion e : pions){
            if(j.getCouleur() == e.getCouleur() && e.getX() == 2){
                j.setScore(1);
                // 1er spot x=2 et y = 0
                // 2e spot x=2 et y = 1
                // 3e spot x=2 et y = 2
            }
        }
    }

    public boolean comparerScore(Joueurs j1 ,Joueurs j2){

        int scoreJ1 = j1.getScore(), scoreJ2 = j2.getScore();
        //j1-j2 >= 6
            return (scoreJ1-scoreJ2) >= 6;
    }

    public String aGagne(Joueurs j1 ,Joueurs j2){
        StringBuilder sb = new StringBuilder();
        sb.append("Le joueur");
        sb.append(comparerScore(j1,j2) ? j1.getCouleur() : j2.getCouleur());
        sb.append("à Gagner\n");
        return sb.toString();
    }
    public boolean Estfini(Joueurs j1 ,Joueurs j2){
        return j1.getScore() >= 12 || j2.getScore() >= 12;
    }
}
