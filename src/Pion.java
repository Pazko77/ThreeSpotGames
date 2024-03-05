import java.util.ArrayList;
@SuppressWarnings("SpellCheckingInspection")
public class Pion {
    private char id;
    public int x,y;
    public ArrayList<Pion> pion;

    public void deplacement(ArrayList<Pion> pion,int positionX, int positionY, char direction){
        Pion pivot = pion.getFirst();
        Pion levier = pion.getLast();
        pivot.x = positionX;
        pivot.y = positionY;
        if(deplacementPossible(pivot,direction))
        {
            switch(direction){
                case 'H':
                    assert(y != 0);
                    levier.x = pivot.x;
                    levier.y = pivot.y-1;
                    break;
                case 'B':
                    assert(y != 2);
                    levier.x = pivot.x;
                    levier.y = pivot.y-1;
                    break;
                case 'G':
                    assert(x != 0);
                    levier.x = pivot.x;
                    levier.y = pivot.y-1;
                    break;
                case 'D':
                    assert(x != 2);
                    levier.x = pivot.x;
                    levier.y = pivot.y+1;
                    break;
            }
        }
        else{
            System.out.println("deplacement impossible");
        }
    }

    public boolean deplacementPossible(Pion pivot,char direction){
        if(direction == 'H'){
            return pivot.y != 0;
        }
        if(direction == 'B'){
            return pivot.y != 2;
        }
        if(direction == 'G'){
            return pivot.x != 0;
        }
        if(direction == 'D'){
            return pivot.x != 2;
        }
        return false; //cas commande inexistant
    }

    public void positionEstDisponible(int posX, int posY){
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (occupe(x,y));
            }
        }
    }
    public Pion(char id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public char getCouleur() {
        return id;
    }

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