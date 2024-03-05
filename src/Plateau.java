import java.util.LinkedList;
@SuppressWarnings("SpellCheckingInspection")

public class Plateau {
    private int largeur, hauteur;
    private LinkedList<Pion> pions;

    /**
     *
     * @param largeur
     * @param hauteur
     */
    public Plateau(int largeur, int hauteur) {
        assert(hauteur > 0 && largeur > 0);
        this.largeur = largeur;
        this.hauteur = hauteur;
        pions = new LinkedList<>();
    }

    public void ajouter(Pion p){
        pions.add(p);
    }

    public Pion occupant(int x, int y){
        for (Pion e : pions){
            if(e.occupe(x,y)){
                return e;
            }
        }
        return null;
    }

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
                sb.append("     " + (e == null ? " " : e.getCouleur()) + "     *");
            }
            sb.append("\n");
            sb.append(colonne);
            sb.append(ligne);
        }
        return sb.toString();
    }
}