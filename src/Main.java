import java.lang.*;
@SuppressWarnings("SpellCheckingInspection")
public class Main {
    public static void main(String[] args) {
        Joueurs PionRouge = new Joueurs('R',0,0);
        Joueurs PionBlanc = new Joueurs('W',0,1);
        Joueurs PionBleu = new Joueurs('B',0,2);

        Plateau plateau = new Plateau(3,3);

        plateau.ajouter(new Pion('0',2,0));
        plateau.ajouter(new Pion('0',2,1));
        plateau.ajouter(new Pion('0',2,2));

        plateau.ajouter(PionRouge.pion.getFirst());
        plateau.ajouter(PionRouge.pion.getLast());

        plateau.ajouter(PionBleu.pion.getFirst());
        plateau.ajouter(PionBleu.pion.getLast());

        plateau.ajouter(PionBlanc.pion.getFirst());
        plateau.ajouter(PionBlanc.pion.getLast());

        System.out.println(plateau);
    }
}