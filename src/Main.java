import java.lang.*;

import static java.lang.System.currentTimeMillis;

public class Main {
    public static void main(String[] args) {
        //Plateau plateau = new Plateau();
        long temps1 = currentTimeMillis();
        for (int j = 0; j < 10; j++) {
            if(j == 0 || j == 9) {
                for (int i = 0; i < 10; i++) {
                    System.out.print("*");
                }
            }
            else{
                System.out.print("*");
                for (int i = 0; i < 8; i++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
        //plateau.Jeu();
        long temps2 = currentTimeMillis();
        System.out.println(temps2-temps1);
        temps1 = currentTimeMillis();
        System.out.println("**********");
        System.out.println("*        *");
        System.out.println("*        *");
        System.out.println("*        *");
        System.out.println("*        *");
        System.out.println("*        *");
        System.out.println("*        *");
        System.out.println("*        *");
        System.out.println("*        *");
        System.out.println("**********");

        //plateau.Jeu();
        temps2 = currentTimeMillis();
        System.out.println(temps2-temps1);
    }
}