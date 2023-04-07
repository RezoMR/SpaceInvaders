
/**
 * Trieda {@code Strelec} slúži na «Vytvorí strelca, zabezpečuje jeho pohyb, a strelbu»…
 *
 * @author   «Matúš Remeň»
 * @version  «1.0 BlueJ»
 */
public class Strelec {
    //atribúty
    private static Obrazok strelec;
    private static Strelec instancia;
    /** @Const
     * Konštruktor objektov triedy Strelec.
     * Vytvorí strelca a dosadí mu príslušný obrázok.
     * @param farba, type int 
     */ 
    public Strelec(int farba) {
        //podla parametra priradi farbu
        if (farba == 1) {
            this.strelec = new Obrazok("Symboly/hnedy.png");
        } 
        if (farba == 2) {
            this.strelec = new Obrazok("Symboly/ruzovy.png");
        } 
        if (farba == 3) {
            this.strelec = new Obrazok("Symboly/biely.png");
        } 
        if (farba == 4) {
            this.strelec = new Obrazok("Symboly/sivy.png");
        }
        this.strelec.zmenPolohu(250, 390); 
        this.strelec.zobraz();
    }
    
    /** @method
     *  @return Vráti inštanciu aplikácii
     *  @param farba, type int
     */ 
    public static Strelec dajInstanciu(int farba) {
        if (instancia == null) {
            instancia = new Strelec(farba);
        }
        return instancia;
    }
    
   /** @method
    * Zabezpečuje pohyb doľava.
    * 
    */
    public void posunVlavo() {
        this.strelec.posunVlavo();
    }
    
    /** @method
     * Zabezpečuje pohyb doprava.
     * 
     */
    public void posunVpravo() {
        this.strelec.posunVpravo();
    }
     
    /** @method
     * Zničí strelca po prehre. Trieda Nepriatelia pošle správu.
     * 
     */
    public static void znic() {
        strelec.skry();
        strelec = null;
    }
    
    /** @method
     * @return Vracia hodnotu X triede Strela.
     * 
       */
    public static int vratX() {
        int xko = strelec.vratLavyHornyX();
        return xko;
    }
    
    /** @method
     * @return Vracia hodnotu Y triede Strela.
     * 
       */
    public static int vratY() {
        int yko = strelec.vratLavyHornyY();
        return yko;
    }
    
    /** @method
     *  Vytvorí strelu.
     */
    public void strel() {
        Strela st = new Strela();
    }
}
