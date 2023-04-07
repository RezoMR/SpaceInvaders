
/**
 * Trieda {@code Strelec} slúži na «Strela, letí, ničí nepriateľov»…
 *
 * @author   «Matúš Remeň»
 * @version  «1.0 BlueJ»
*/
public class Strela {
    //atribúty
    private Obrazok strela;
    private Manazer manazer;
    private boolean leti;
    /** @const
     * Konštruktor objektov triedy Strelec.
     * Vytvorí strelu, dosadí jej obrázok.
     * Vytvorí manažéra, a ten následne spravuje pohyb strely.
     */
    public Strela() {
        this.leti = true;
        this.strela = new Obrazok("Symboly/strela.png");
        this.manazer = new Manazer();
        this.strela.zmenPolohu(Strelec.vratX() + 5, Strelec.vratY() - 10);
        this.strela.zobraz();
        this.manazer.spravujObjekt(this);
    }
    
    /** @method
     * Skryje strelu z plátna.(Zničí ju a ukončí jej pohyb.)
     * 
     */
    public void znicVybuch() {
        this.strela.skry();
        this.leti = false;
    }
    
    /** @method
     *  Zabezpečuje pohyb strely.
     */
    public void tik() {
        if (this.leti) {
            if (this.strela.vratLavyHornyY() > 0 && !Nepriatelia.stretliSa(this)) {
                this.strela.pomalyPosunZvisle( -20);
                if ((this.strela.vratLavyHornyY() <= 0) || Nepriatelia.stretliSa(this)) {
                    this.znicVybuch();
                }
            }
        }
    }
    
    /** @method
     *  @return Vracia X hodnotu lavého horného rohu strely.
     * 
     */
    public int vratX() {
        int xko = this.strela.vratLavyHornyX();
        return xko;
    }
    
    /** @method
     *  @return Vracia Y hodnotu lavého horného rohu strely.
     * 
     */
    public int vratY() {
        int yko = this.strela.vratLavyHornyY();
        return yko;
    }
    
    
    
}
    

