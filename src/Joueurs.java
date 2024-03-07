import java.util.ArrayList;

@SuppressWarnings("SpellCheckingInspection")
public class Joueurs {
    private int score;
    private char couleur;
    public ArrayList<Pion> pion = new ArrayList<>();

    /**
     * @brief Initialise un joueur avec ses positions par defaut
     * @param couleur Couleur du joueur
     * @param x Position X de départ
     * @param y Position Y de départ
     */
    public Joueurs (char couleur, int x, int y) {
        pion.add(new Pion(couleur,x,y));
        pion.addLast(new Pion(couleur,x+1,y));
        this.score = 0; // initialise le score à 0
        this.couleur = couleur;
    }

    public char getCouleur() {
        return couleur;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }
}