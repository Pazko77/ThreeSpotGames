import java.lang.*;
import java.util.Scanner;

@SuppressWarnings("SpellCheckingInspection")
public class Main {
    public static boolean joueurCourant;
    public static void main(String[] args) {

        Joueurs Rouge = new Joueurs('R',1,0);
        Joueurs Blanc = new Joueurs('W',1,1);
        Joueurs Bleu = new Joueurs('B',1,2);
        Plateau plateau = new Plateau(3,3);

        Scanner sc = new Scanner(System.in);

        plateau.ajouter(Rouge.pion.getFirst());
        plateau.ajouter(Rouge.pion.getLast());

        plateau.ajouter(Bleu.pion.getFirst());
        plateau.ajouter(Bleu.pion.getLast());

        plateau.ajouter(Blanc.pion.getFirst());
        plateau.ajouter(Blanc.pion.getLast());

        while (!Jeu.EstFini(Rouge, Bleu)){
            Joueurs courant;

            if(joueurCourant)
                courant = Rouge;
            else
                courant = Bleu;

            plateau.positionNonOccuper();
            System.out.println(plateau.toStringBefore());
            System.out.println(plateau.toStringAfter());
            plateau.positionNonOccuper();
            System.out.println("Joueur "+courant.getCouleur()+" à vous de jouez :");
            int pos1 = 0 ,pos2 = 0;
            while(!plateau.saisieDeplacementCorrect(pos1,pos2)) {
                System.out.println("Saississez deux position différente disponible sur le plateau :");
                pos1 = sc.nextInt();pos2 = sc.nextInt();
                plateau.deplacement(courant, pos1, pos2);
            }
            Jeu.score(courant,plateau.getPions());
            System.out.println(plateau.toStringAfter());
            plateau.clearPositionVide();
            plateau.positionNonOccuper();
            System.out.println(plateau.toStringBefore());
            System.out.println("Joueur "+courant.getCouleur()+" jouez le pion neutre :");
            pos1 = 0;
            pos2 = 0;
            courant = Blanc;
            while(!plateau.saisieDeplacementCorrect(pos1,pos2)) {
                pos1 = sc.nextInt();pos2 = sc.nextInt();
                plateau.deplacement(courant, pos1, pos2);
            }
            System.out.println(plateau.toStringAfter());
            plateau.clearPositionVide();
            joueurCourant = !joueurCourant;
        }
    }
}
