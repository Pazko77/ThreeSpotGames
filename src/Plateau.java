import java.util.LinkedList;
@SuppressWarnings("SpellCheckingInspection")

public class Plateau {
    private final int largeur;
    private final int hauteur;
    private LinkedList<Pion> pions;
    private LinkedList<Pion> positionVide;

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
        positionVide = new LinkedList<>();
    }

    /**
     * @brief rajoute une objet pion dans une liste chainee
     * @param j le pion a ajouter dans la liste chainee
     */
    public void ajouter(Joueurs j){
        pions.addAll(j.pion);
    }

    public void supprimer(Joueurs j){
        for (int i = 0; i < pions.size(); i++) {
            if (j.getCouleur() == pions.get(i).getId()){
                pions.remove(i);
                pions.remove(i);
            }
        }
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

    public Pion occupantVide(int x, int y){
        for (Pion e : positionVide){
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
    public String toStringBefore() {
        StringBuilder sb = new StringBuilder();
        final String ligne = "*  *  *  *  *  *  *  *  *  *  *  *  *\n";
        final String colonne="*           *           *           *\n";
        sb.append(ligne);
        for(int y = 0; y < hauteur ; ++y) {
            sb.append(colonne);
            sb.append("*");
            for (int x = 0; x < largeur; ++x) {
                Pion e = occupant(x,y);
                Pion f = occupantVide(x,y);
                sb.append("     " +(e != null ? e.getId() : (f != null ? f.getId() : x == 2 ? "O" :" "))+ "     *");
            }
            sb.append("\n");
            sb.append(colonne);
            sb.append(ligne);
        }
        return sb.toString();
    }

    public String toStringAfter() {
        StringBuilder sb = new StringBuilder();
        final String ligne = "*  *  *  *  *  *  *  *  *  *  *  *  *\n";
        final String colonne="*           *           *           *\n";
        sb.append(ligne);
        for(int y = 0; y < hauteur ; ++y) {
            sb.append(colonne);
            sb.append("*");
            for (int x = 0; x < largeur; ++x) {
                Pion e = occupant(x,y);
                sb.append("     " +(e != null ? e.getId() : x == 2 ? "O":" ")+ "     *");
            }
            sb.append("\n");
            sb.append(colonne);
            sb.append(ligne);
        }
        return sb.toString();
    }

    /**
     * @brief crée un pion symbolisant une position vide lorsqu'il ne le trouve pas dans la liste pions
     */
    public void positionNonOccuper(){
        int compteur = 0;
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                boolean positionOccuper = false;
                for (Pion e : pions) {
                    if (e.occupe(x, y)) {
                        positionOccuper = true;
                        break;
                    }
                }
                if (!positionOccuper) {
                    compteur++;
                    Pion p = new Pion((char)('0'+compteur), x, y);
                    positionVide.add(p);
                }
            }
        }
    }

    /**
     * @brief efface entièrement la liste chainée
     */
    public void clearPositionVide(){
        positionVide.clear();
    }

    /**
     * @param j
     * @param pos1
     * @param pos2
     */
    public void deplacement(Joueurs j,int pos1, int pos2){
        j.pion.getFirst().setX(positionVide.get(pos1-1).x);
        j.pion.getFirst().setY(positionVide.get(pos1-1).y);
        j.pion.getLast().setX(positionVide.get(pos2-1).x);
        j.pion.getLast().setY(positionVide.get(pos2-1).y);
    }

    /**
     * @param pos1
     * @param pos2
     * @return vrai si les position 1 et 2 sont différent et qu'ils sont compris entre 1 et la taille de PositionVide
     */
    public boolean saisieDeplacementCorrect(int pos1, int pos2){
        return (pos1!=pos2)
                && (pos1 > 0 && pos1 <= positionVide.size())
                && (pos2 > 0 && pos2 <= positionVide.size());
                //&& ((positionVide.get(pos1).getX() == positionVide.get(pos2).getX() && positionVide.get(pos1).getX() - positionVide.get(pos2).getX() == 1)
                //|| (positionVide.get(pos1).getY() == positionVide.get(pos2).getY() && positionVide.get(pos1).getY() - positionVide.get(pos2).getY() == 1));
    }

    public LinkedList<Pion> getPions() {
        return pions;
    }

    //vérifie
    // positionVide.get(pos1).getX()
    // if (pos1.getX() == pos2.getX() && (pos1.getX() - pos2.getX() == 1) || (pos1.getY() == pos2.getY() && (pos1.getY() - pos2.getY() == 1))
}