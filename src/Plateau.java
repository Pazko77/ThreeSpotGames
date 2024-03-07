import java.util.LinkedList;
@SuppressWarnings("SpellCheckingInspection")

public class Plateau {
    private int largeur, hauteur;
    private LinkedList<Pion> pions;

    /**
     * @brief Initialise le plateau du jeu
     * @param largeur largeur du plateau
     * @param hauteur hauteur du plateau
     */
    public Plateau(int largeur, int hauteur) {
        assert(hauteur > 0 && largeur > 0);
        this.largeur = largeur;
        this.hauteur = hauteur;
        pions = new LinkedList<>();
    }

    /**
     * @brief rajoute une objet pion dans une liste chainee
     * @param p le pion a ajouter dans la liste chainee
     */
    public void ajouter(Pion p){
        pions.add(p);
    }

    /**
     * @brief Cherche un pion avec les coordonnée correspondant à x et y
     * @param x position x rechercher
     * @param y position y rechercher
     * @return renvoie le pion sinon null
     */
    public Pion occupant(int x, int y){
        for (Pion e : pions){
            if(e.occupe(x,y)){
                return e;
            }
        }
        return null;
    }

    /**
     * @brief Créer le tableau sous forme de chaine de caractère avec tout les éléments dessus
     * @return affichage du tableau
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        final String ligne = "*  *  *  *  *  *  *  *  *  *  *  *  *\n";
        final String colonne="*           *           *           *\n";
        sb.append(ligne);
        for(int y = 0; y < hauteur ; ++y) {
            sb.append(colonne);
            sb.append("*");
            for (int x = 0; x < largeur; ++x) {
                Pion e = occupant(x,y);
                sb.append("     " +(e != null ? e.getCouleur() : x == 2 ? "0":" ")+ "     *");
            }
            sb.append("\n");
            sb.append(colonne);
            sb.append(ligne);
        }
        return sb.toString();
    }
}