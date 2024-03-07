import java.util.ArrayList;
@SuppressWarnings("SpellCheckingInspection")
public class Pion {
    private char id;
    public int x,y;
    //public ArrayList<Pion> pion;

//    public void deplacement(ArrayList<Pion> pion,int positionX, int positionY, char direction){
//        Pion pivot = pion.getFirst();
//        Pion levier = pion.getLast();
//        pivot.x = positionX;
//        pivot.y = positionY;
//        if(deplacementPossible(pivot,direction))
//        {
//            switch(direction){
//                case 'H':
//                    assert(y != 0);
//                    levier.x = pivot.x;
//                    levier.y = pivot.y-1;
//                    break;
//                case 'B':
//                    assert(y != 2);
//                    levier.x = pivot.x;
//                    levier.y = pivot.y-1;
//                    break;
//                case 'G':
//                    assert(x != 0);
//                    levier.x = pivot.x;
//                    levier.y = pivot.y-1;
//                    break;
//                case 'D':
//                    assert(x != 2);
//                    levier.x = pivot.x;
//                    levier.y = pivot.y+1;
//                    break;
//            }
//        }
//        else{
//            System.out.println("deplacement impossible");
//        }
//    }

//    public boolean deplacementPossible(Pion pivot,char direction){
//        if(direction == 'H'){
//            return pivot.y != 0;
//        }
//        if(direction == 'B'){
//            return pivot.y != 2;
//        }
//        if(direction == 'G'){
//            return pivot.x != 0;
//        }
//        if(direction == 'D'){
//            return pivot.x != 2;
//        }
//        return false; //cas commande inexistant
//    }

    /*
     Idée alternative a ce début de code. Crée une liste propre au déplacement
     A chaque manche au début on crée un liste avec tout les déplacements puis après le déplacemenet
     on détruit cette liste.
     */

    public boolean deplacement(ArrayList<Pion> j, int Pos1, int Pos2){
        /*
        for(Pion p : pions)
        if(Pos1 == p.Id)

         */
        return false;
    }

    /**
     * @brief vérifie si une position x et y données est disponible (vide)
     * @param posX Position axe X
     * @param posY Position axe Y
     */
    public void positionEstDisponible(int posX, int posY){
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (occupe(x,y));
            }
        }
    }

    /**
     * @brief initialise un pion
     * @param id identifiant
     * @param x position axe x
     * @param y position axe y
     */
    public Pion(char id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public char getId() {
        return id;
    }

    /**
     * @brief Vérifie un pion occupe les positions x et y
     * @param x Position axe x
     * @param y Position axe y
     * @return renvoie vrai si pion.x égale à x et pion.y égale à y sinon faux
     */
    public boolean occupe(int x, int y){
        return this.x == x && this.y == y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}