import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Trieda {@code Aplikácia} slúži na «Ovládanie celej hry, spustenie a 
 *                                      zapisovanie skore»…
 *
 * @author   «Matúš Remeň»
 * @version  «1.0 BlueJ verzia»
 */
public class Aplikacia {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 2; i++) {
            Scanner skenuje = new Scanner(System.in);
            Scanner skenuje2 = new Scanner(System.in);
            System.out.println("Vitajte v hre Space Invaders!");
            System.out.println("Vyberte si farbu strelca cislom:");
            System.out.println("1__hnedy");
            System.out.println("2__ruzovy");
            System.out.println("3__biely");
            System.out.println("4__sivy");
            int farba  = skenuje2.nextInt();
            if (farba > 4 || farba < 1) {
                System.out.println("Verím že to bol miss click :) ");
                System.out.println("Spustite hru znova");
                break;
            }
            System.out.println("Pre začatie hry stlačte 1");
            System.out.println("Pre skončenie hry stlačte 0");
            int volba  = skenuje.nextInt();
            if (volba > 1 || volba < 0) {
                System.out.println("Verím že to bol miss click :) ");
                System.out.println("Spustite hru znova");
                break;
            }
            if (volba == 1) {
                Strelec jedina = Strelec.dajInstanciu(farba);
                Manazer man = new Manazer();
                man.spravujObjekt(jedina);
                Nepriatelia viac = Nepriatelia.dajInstanciu();
            } else {
                break;
            }
            System.out.println(Nepriatelia.vyhodnotenie());
            Scanner skenuje3 = new Scanner(System.in);
            System.out.println("Pre uloženie výsledku stlačte 1 ");
            int zapisanie = skenuje3.nextInt();
            if (zapisanie == 1) {
                Scanner skenuje4 = new Scanner(System.in);
                System.out.println("Zadajte svoje meno: ");
                String nazov = skenuje4.nextLine();
                try {
                    File subor = new File(nazov);
                    PrintWriter pise = new PrintWriter(nazov + ".txt");
                    pise.print(Nepriatelia.vyhodnotenie());
                    pise.println();
                    pise.close();
                    System.out.println("Ďakujeme za hranie našej hry");
                    System.out.println("Matúš Remeň Corporation 2021");
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Ďakujeme za hranie našej hry");
                System.out.println("Matúš Remeň Corporation 2021");
                break;
            }
        }
    }
}
    
    

