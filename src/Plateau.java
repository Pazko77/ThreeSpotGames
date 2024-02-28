public class Plateau {
    private final int LIGNE_MAX = 3;
    private final int COLONNE_MAX = 3;
    private int ligne;
    private int colonne;
    private static String[][] Spot;

    public Plateau() {
        Spot = new String[][]{
                {" ", " ", "O"},
                {" ", " ", "O"},
                {" ", " ", "O"}
        };
    }

    public void Jeu() {
        int x, y = x = 0;
        final int taille = 13; // Taille de la grille (13x13)
        final int espacementRow = 4; // lignes
        final int emplacementValeur = 2; // Les lignes où les valeurs se trouve
        final int espacementCol = 3; // colonnes

        for (int i = 0; i < taille; i++) {
            if (i % emplacementValeur == 0 && i % 4 != 0){
                System.out.print(" * ");
                for (int j = 0; j < 3; j++) {
                    System.out.print("    "+Spot[y][x++]+"     * ");
                }
                x=0;
                y++;
            }
            else if (i % espacementRow == 0) {
                for (int j = 0; j < taille; j++) {
                    System.out.print(" * ");
                }
            } else {
                System.out.print(" * ");
                for (int j = 0; j < taille - 2; j++) {
                    if(j % espacementCol == 0 && j != 0) {
                        System.out.print(" * ");
                    }
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

    }
}