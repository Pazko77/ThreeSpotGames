import org.junit.jupiter.api.Test;

class PlateauTest {
    @Test
    void ajouterTest() {
        Plateau plateau = new Plateau(3,3);
        plateau.ajouter(new Joueur('1',0,1));
        assert(plateau.getPions().size() == 2);
        plateau.ajouter(new Joueur('2',0,1));
        assert(plateau.getPions().size() == 4);
    }

    @Test
    void supprimerTest() {
        Plateau plateau = new Plateau(3,3);
        Joueur joueur1 = new Joueur('1',1,1);
        plateau.ajouter(joueur1);
        Joueur joueur2 = new Joueur('2',0,1);
        plateau.ajouter(joueur2);
        plateau.supprimer(joueur2);
        assert(plateau.getPions().size()==2);
        plateau.supprimer(joueur1);
        assert(plateau.getPions().isEmpty());
    }

    @Test
    void occupantTest() {
        Plateau plateau = new Plateau(3,3);
        Joueur joueur1 = new Joueur('1',1,1);
        plateau.ajouter(joueur1);
        Pion e = plateau.occupant(1,1);
        assert(e.getX() == 1 && e.getY() == 1 && e.getId()=='1');
        Joueur joueur2 = new Joueur('2',1,2);
        plateau.ajouter(joueur2);
        e = plateau.occupant(1,2);
        assert(e.getX() == 1 && e.getY() == 2 && e.getId()=='2');
    }

    @Test
    void positionNonOccuperTest() {
        Plateau plateau = new Plateau(3,3);
        Joueur joueur1 = new Joueur('B',1,1);
        plateau.ajouter(joueur1);
        Joueur joueur2 = new Joueur('R',1,0);
        plateau.ajouter(joueur2);
        plateau.positionNonOccuper();
        assert(plateau.getPositionVide().size()==5);
        plateau.supprimer(joueur2);
        plateau.clearPositionVide();
        plateau.positionNonOccuper();
        System.out.println(plateau.getPositionVide().size());
        assert(plateau.getPositionVide().size()==7);
    }

    @Test
    void clearPositionVideTest() {
        Plateau plateau = new Plateau(3,3);
        Joueur joueur1 = new Joueur('1',1,1);
        plateau.ajouter(joueur1);
        Joueur joueur2 = new Joueur('2',0,1);
        plateau.ajouter(joueur2);
        plateau.positionNonOccuper();
        assert(!plateau.getPositionVide().isEmpty());
        plateau.clearPositionVide();
        assert(plateau.getPositionVide().isEmpty());
    }

    @Test
    void deplacementTest() {

    }
}