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
        if(scoreJ1 > scoreJ2)
            return (scoreJ1-scoreJ2) >= 6;
        else
            return (scoreJ2-scoreJ1) >= 6;
    }

    public String aGagne(Joueurs j1 ,Joueurs j2){
        if (comparerScore(j1, j2)){

        }
        return "\0";
    }
    public boolean Estfini(){
        return false;
    }
}
