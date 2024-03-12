import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void ajouter() {
        Plateau plateau = new Plateau(3,3);
        System.out.println(plateau.getPions());
        Joueurs J1 = new Joueurs('1',0,1);
        plateau.ajouter(J1);
        System.out.println(plateau.getPions());
    }

    @Test
    void supprimer() {
    }

    @Test
    void occupant() {
    }

    @Test
    void occupantVide() {
    }

    @Test
    void positionNonOccuper() {
    }

    @Test
    void clearPositionVide() {
    }

    @Test
    void deplacement() {
    }
}