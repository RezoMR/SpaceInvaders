
/**
 * Trieda {@code Nepriatelia} slúži na «Vytvorenie nepriateľov, ich pohyb, po konci hry vyhodnotí výsledok a spočíta dosiahnuté skóre»…
 *
 * @author   «Matúš Remeň»
 * @version  «1.0 BlueJ»
 */
public class Nepriatelia {
    //atribúty
    private static Nepriatelia instancia;
    private static Obrazok[][] zoznamNepriatelov;
    private static boolean vysledok;
    
    /** @constr
     * Konštruktor objektu Nepriatelia vytvorí nepriateľov, 
     * načíta im prislúchajúci obrázok, určí im polohu,
     * vykreslí ich a pošle im správu na pohyb.
     */
    public Nepriatelia() {
        this.vysledok = false;
        Obrazok enemy;
        this.zoznamNepriatelov = new Obrazok[3][10];
        for (int i = 0; i < 10;i++) {
            //prvy rad
            enemy = new Obrazok("symboly/nepria.png");
            enemy.zmenPolohu(((i * 20) + 5), 10);
            enemy.zobraz();
            zoznamNepriatelov[0][i] = enemy;
        }
        for (int i = 0; i < 10;i++) {
            //druhy rad
            enemy = new Obrazok("symboly/nepria.png");
            enemy.zmenPolohu(((i * 20) + 5), 30);
            enemy.zobraz();
            zoznamNepriatelov[1][i] = enemy;
        }
        for (int i = 0; i < 10 ;i++) {
            //treti rad
            enemy = new Obrazok("symboly/nepria.png");
            enemy.zmenPolohu(((i * 20) + 5), 50);
            enemy.zobraz();
            zoznamNepriatelov[2][i] = enemy;
        }
        this.pohyb();
    }
    
    /** @method
     *  @return Vráti inštanciu aplikácii
       */
    public static Nepriatelia dajInstanciu() {
        if (instancia == null) {
            instancia = new Nepriatelia();
        }
        return instancia;
    }

    /** @method
     * Metóda stretli sa overuje či sa strela 
     * stretla pri svojom lete s niektorým s nepriateľov.
     * Návratová hodnota je boolean.
     * @return boolean či sa stretli.
     * @param strela, type Strela
    */ 
    public static boolean stretliSa(Strela strela) {
        boolean pravda = false;
        if (zoznamNepriatelov[0].length == 0 && zoznamNepriatelov[1].length == 0 && zoznamNepriatelov[2].length == 0) {
            System.out.println("Vyhral si");
        } else {
            for (int i = 0; i < zoznamNepriatelov[0].length;i++) {
                if (Math.abs(Nepriatelia.zoznamNepriatelov[0][i].vratLavyHornyX() - strela.vratX()) <= 10 && Math.abs(Nepriatelia.zoznamNepriatelov[0][i].vratLavyHornyY() - strela.vratY()) <= 10 && Nepriatelia.zoznamNepriatelov[0][i].vidno()) {
                    Nepriatelia.zoznamNepriatelov[0][i].skry();
                    pravda = true;
                } 
            } 
            for (int i = 0; i < zoznamNepriatelov[1].length;i++) {    
                if (Math.abs(Nepriatelia.zoznamNepriatelov[1][i].vratLavyHornyX() - strela.vratX()) <= 10 && Math.abs(Nepriatelia.zoznamNepriatelov[1][i].vratLavyHornyY() - strela.vratY()) <= 10 && Nepriatelia.zoznamNepriatelov[1][i].vidno()) {
                    Nepriatelia.zoznamNepriatelov[1][i].skry();
                    pravda = true;
                } 
            }
            for (int i = 0; i < zoznamNepriatelov[2].length;i++) {
                if (Math.abs(Nepriatelia.zoznamNepriatelov[2][i].vratLavyHornyX() - strela.vratX()) <= 10 && Math.abs(Nepriatelia.zoznamNepriatelov[2][i].vratLavyHornyY() - strela.vratY()) <= 10 && Nepriatelia.zoznamNepriatelov[2][i].vidno()) {
                    Nepriatelia.zoznamNepriatelov[2][i].skry();
                    pravda = true;
                } 
            }
        }
        return pravda;
    }
   
    /** @method
     *  Metóda pohyb zabezpečuje pohyb nepriateľov. 
     *  Keď sa nakonci skončí vyhodnotí a vypíše do okna v
     * 
    */
    public void pohyb() {
        int y = 0;
        while (y < 5) {
            int x = 0;
            while (x < 15) {
                //vpravo
                for (int i = 9; i > -1; i--) {
                    this.zoznamNepriatelov[0][i].posunVodorovne(20);
                    this.zoznamNepriatelov[1][i].posunVodorovne(20);
                    this.zoznamNepriatelov[2][i].posunVodorovne(20);
                }
                x++;   
            }
            //dole
            for (int i = 9; i > -1; i--) {
                this.zoznamNepriatelov[2][i].posunZvisle(30);
                this.zoznamNepriatelov[1][i].posunZvisle(30);
                this.zoznamNepriatelov[0][i].posunZvisle(30);
            }
            x = 0;       
            while (x < 15) {
                //vlavo
                for (int i = 0; i < this.zoznamNepriatelov[1].length; i++) {
                    this.zoznamNepriatelov[0][i].posunVodorovne(-20);
                    this.zoznamNepriatelov[1][i].posunVodorovne(-20);
                    this.zoznamNepriatelov[2][i].posunVodorovne(-20);
                }
                x++;   
            }   
            //dole
            for (int i = 9; i > -1; i--) {
                this.zoznamNepriatelov[2][i].posunZvisle(30);
                this.zoznamNepriatelov[1][i].posunZvisle(30);
                this.zoznamNepriatelov[0][i].posunZvisle(30);
            }  
            y++;   
        }  
        for (int i = 9; i > -1; i--) {
            //vpravo
            this.zoznamNepriatelov[0][i].posunVodorovne(20);
            this.zoznamNepriatelov[1][i].posunVodorovne(20);
            this.zoznamNepriatelov[2][i].posunVodorovne(20);
        }
        for (int i = 9; i > -1; i--) {
            //dole
            this.zoznamNepriatelov[2][i].posunZvisle(30);
            this.zoznamNepriatelov[1][i].posunZvisle(30);
            this.zoznamNepriatelov[0][i].posunZvisle(30);
        } 
        for (int i = 0; i < this.zoznamNepriatelov[0].length; i++) {
            //rozhodovanie o vysledku
            if (!this.zoznamNepriatelov[0][i].vidno() && (!this.zoznamNepriatelov[1][i].vidno()) && (!this.zoznamNepriatelov[2][i].vidno())) {
                vysledok = true;
            } else { 
                Strelec.znic();
                vysledok = false;
                break;
            } 
        }     
    }
    
    /** @method
     * 
     *  Metóda vráti výsledok hry a dosiahnute skore.
     *  @return String o výsledku a skóre
    */  
    public static String vyhodnotenie() {
        //pomocna premenna
        int i = 0;
        //skore
        int skore = 0;
        //vysledok boolean 
        String vys = null;
        //pocita skore
        while (i < zoznamNepriatelov[0].length) {
            if (!zoznamNepriatelov[0][i].vidno()) {
                skore++;
            } 
            if (!zoznamNepriatelov[1][i].vidno()) {
                skore++;
            } 
            if (!zoznamNepriatelov[2][i].vidno()) {
                skore++;
            } 
            i++;
        }
        if (vysledok) {
            vys = ("Vyhral si" + " Tvoje Skore: " + skore);
        } else {
            vys = ("Prehral si" + " Tvoje Skore: " + skore);
        }
        return vys;
    }
} 

