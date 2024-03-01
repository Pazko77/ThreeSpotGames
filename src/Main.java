import java.lang.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Pion pionR = new Pion();
        pionR.pion= new ArrayList<Pion>();
        pionR.pion.add(new Pion('R',0,0));
        pionR.pion.addLast(new Pion('R',0,1));
//        Plateau plateau = new Plateau(3,3);
//        plateau.ajouter(new Pion('0',2,0));
//        plateau.ajouter(new Pion('0',2,1));
//        plateau.ajouter(new Pion('0',2,1));
//        plateau.ajouter(new Pion('0',2,2));
//        System.out.println(plateau.toString());
    }
}