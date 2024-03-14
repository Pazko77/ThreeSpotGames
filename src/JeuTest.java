import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JeuTest {

    @Test
    void scoreTest() {
        Joueur rouge = new Joueur('R',1,0);
        Plateau plateau = new Plateau(3,3);
        plateau.ajouter(rouge);
        Jeu.score(rouge,plateau.getPions());
        assert(rouge.getScore()==1);
    }

    @Test
    void comparerScoreTest() {
        Joueur rouge = new Joueur('R',1,0);
        Joueur bleu = new Joueur('B',1,1);
        Plateau plateau = new Plateau(3,3);
        plateau.ajouter(rouge);
        plateau.ajouter(bleu);
        for (int i = 0; i < 13; i++) {
            Jeu.score(rouge,plateau.getPions());
        }
        for (int i = 0; i < 6; i++) {
            Jeu.score(bleu,plateau.getPions());
        }
        assert(Jeu.comparerScore(rouge,bleu) == 'B');
        for (int i = 0; i < 4; i++) {
            Jeu.score(bleu,plateau.getPions());
        }
        assert(Jeu.comparerScore(rouge,bleu) == 'R');
    }

    @Test
    void estFini() {
        Joueur rouge = new Joueur('R',1,0);
        Joueur bleu = new Joueur('B',1,1);
        Plateau plateau = new Plateau(3,3);
        plateau.ajouter(rouge);
        plateau.ajouter(bleu);
        for (int i = 0; i < 6; i++) {
            Jeu.score(rouge,plateau.getPions());
        }
        for (int i = 0; i < 6; i++) {
            Jeu.score(bleu,plateau.getPions());
        }
        assert(!Jeu.EstFini(rouge, bleu));
        for (int i = 0; i < 6; i++) {
            Jeu.score(rouge,plateau.getPions());
        }

        assert(Jeu.EstFini(rouge, bleu));
    }
}