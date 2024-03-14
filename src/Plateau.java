import java.util.LinkedList;
@SuppressWarnings("SpellCheckingInspection")

public class Plateau {
    private final int largeur;
    private final int hauteur;
    private final LinkedList<Pion> pions;
    private final LinkedList<Pion> positionVide;

    public LinkedList<Pion> getPositionVide() {
        return positionVide;
    }

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
    public void ajouter(Joueur j){
        pions.addAll(j.pion);
    }

    public void supprimer(Joueur joueur){
        for (int i = 0; i < pions.size(); i++) {
            if (joueur.getCouleur() == pions.get(i).getId()){
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
                sb.append("     ").append(e != null ? e.getId() : (f != null ? f.getId() : x == 2 ? "O" : " ")).append("     *");
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
                sb.append("     ").append(e != null ? e.getId() : x == 2 ? "O" : " ").append("     *");
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
     * @param joueur le joueur
     * @param pos1 première position
     * @param pos2 deuxième position
     */
    public void deplacement(Joueur joueur, int pos1, int pos2){
        joueur.pion.getFirst().setX(positionVide.get(pos1-1).getX());
        joueur.pion.getFirst().setY(positionVide.get(pos1-1).getY());
        joueur.pion.getLast().setX(positionVide.get(pos2-1).getX());
        joueur.pion.getLast().setY(positionVide.get(pos2-1).getY());
    }

    /**
     * @param pos1 première position
     * @param pos2 deuxième position
     * @return vrai si les position 1 et 2 sont différent et qu'ils sont compris entre 1 et la taille de PositionVide
     */
    public boolean saisieDeplacementCorrect(int pos1, int pos2){
        if(pos1 == pos2)
            return false;
        if(pos1 < 0 || pos1 > positionVide.size())
            return false;
        if(pos2 < 0 || pos2 > positionVide.size())
            return false;
        int pos1X = positionVide.get(pos1-1).getX();
        int pos1Y = positionVide.get(pos1-1).getY();
        int pos2X = positionVide.get(pos2-1).getX();
        int pos2Y = positionVide.get(pos2-1).getY();
        if((pos1X == pos2X) && (pos1Y != pos2Y)){
            if(pos1Y < pos2Y)
                return (pos2Y - pos1Y) < 2;
            else
                return (pos1Y - pos2Y) < 2;
        }
        if((pos1Y == pos2Y) && (pos1X != pos2X)){
            if(pos1X< pos2X)
                return (pos2X - pos1X) < 2;
            else
                return (pos1X - pos2X) < 2;
        }
        return false;
    }

    public LinkedList<Pion> getPions() {
        return pions;
    }
}