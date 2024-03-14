@SuppressWarnings("SpellCheckingInspection")
public class Pion {
    private final char id;
    private int x,y;

    /**
     * @brief initialise un pion
     * @param id identifiant
     * @param x position axe x
     * @param y position axe y
     */
    public Pion(char id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public char getId() {
        return id;
    }

    /**
     * @brief Vérifie un pion occupe les positions x et y
     * @param x Position axe x
     * @param y Position axe y
     * @return renvoie vrai si pion.x égale à x et pion.y égale à y sinon faux
     */
    public boolean occupe(int x, int y){
        return this.x == x && this.y == y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}