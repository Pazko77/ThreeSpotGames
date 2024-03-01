public class Pion {
    private char couleur;

    private int x, y;
    public ArrayList<Pion> pion;

    public Pion() {
    }

    public void deplacement(ArrayList<Pion> pion, int pos, char direction){
        //HautBasGaucheDroite
        Pion pivot = pion.getFirst();
        Pion levier = pion.getLast();
        //pivot.x = pos.x;
        //pivot.y = pos.y;
        if(deplacementPossible(pivot,direction))
        {
            switch(direction){
                case 'H':
                //condition y != 0
                //levier.x = pivot.x
                //levier.y = pivot.y-1
                    break;
                case 'B':
                //condition y != 2
                //levier.x = pivot.x
                //levier.y = pivot.y-1
                    break;
                case 'G':
                //condition x != 0
                //levier.x = pivot.x
                //levier.y = pivot.y-1
                    break;
                case 'D':
                    //condition y != 2
                    //levier.x = pivot.x
                    //levier.y = pivot.y+1
                    break;
                default:
                    //bouge pas;
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
    public Pion(char couleur, int x, int y) {
        this.couleur = couleur;
        this.x = x;
        this.y = y;
    }
}
