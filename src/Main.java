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
        plateau.ajouter(Rouge);
        plateau.ajouter(Bleu);
        plateau.ajouter(Blanc);

        while (true){
            Joueurs courant;
            if(joueurCourant)
                courant = Rouge;
            else
                courant = Bleu;

            plateau.supprimer(courant);
            plateau.positionNonOccuper();
            System.out.println(plateau.toStringBefore());
            plateau.ajouter(courant);
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
            System.out.println(Jeu.affichageScore(Rouge,Bleu));
            if(Jeu.EstFini(Rouge, Bleu))
                break;
            courant = Blanc;
            plateau.supprimer(courant);
            plateau.positionNonOccuper();
            System.out.println(plateau.toStringBefore());
            plateau.ajouter(courant);
            System.out.println("Joueur "+courant.getCouleur()+" jouez le pion neutre :");
            pos1 = 0;
            pos2 = 0;
            while(!plateau.saisieDeplacementCorrect(pos1,pos2)) {
                pos1 = sc.nextInt();pos2 = sc.nextInt();
                plateau.deplacement(courant, pos1, pos2);
            }
            System.out.println(plateau.toStringAfter());
            plateau.clearPositionVide();
            joueurCourant = !joueurCourant;
        }
        System.out.println(Jeu.aGagne(Rouge,Bleu));
    }
}
