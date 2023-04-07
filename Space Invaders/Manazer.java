import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * Automaticky posiela spravy danym objektom:<br />
 * posunVlavo() - pri stlacen klavesy A<br />
 * posunVpravo() - pri stlaceni klavesy D<br />
 * strel() - pri stlaceni klavesy SPACE<br />
 * zrus() - pri stlaceni klavesy ESC<br />
 * tik() - kazdych 0,25 sekundy<br />
 * vyberSuradnice(x, y) - pri kliknuti mysou
 */
public class Manazer {
    private ArrayList<Object> aSpravovaneObjekty;
    private long aOldTick;
    private static final long TICK_LENGTH = 250000;
    
    private class ManazerKlaves extends KeyAdapter {
        public void keyPressed(KeyEvent paEvt) {
            if (paEvt.getKeyCode() == KeyEvent.VK_A) {
                Manazer.this.posliSpravu("posunVlavo");
            } else if (paEvt.getKeyCode() == KeyEvent.VK_D) {
                Manazer.this.posliSpravu("posunVpravo");
            } else if (paEvt.getKeyCode() == KeyEvent.VK_SPACE) {
                Manazer.this.posliSpravu("strel");
            } else if (paEvt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                Manazer.this.posliSpravu("zrus");
            }
        }
    }
    
    private class ManazerCasovaca implements ActionListener {
        public void actionPerformed(ActionEvent paEvt) {
            long newTick = System.nanoTime();
            if (newTick - aOldTick >= TICK_LENGTH || newTick < TICK_LENGTH) {
                aOldTick = (newTick / TICK_LENGTH) * TICK_LENGTH;
                Manazer.this.posliSpravu("tik");
            }
        }
    }
    
    private class ManazerMysi extends MouseAdapter {
        public void mouseClicked(MouseEvent paEvt) {
            if (paEvt.getButton() == MouseEvent.BUTTON1) {
                Manazer.this.posliSpravu("vyberSuradnice", paEvt.getX(), paEvt.getY());
            }
        }
    }
    
    private void posliSpravu(String paSelektor) {
        for (Object adresat : aSpravovaneObjekty) {
            try {
                Method sprava = adresat.getClass().getMethod(paSelektor);
                sprava.invoke(adresat);
            } catch (SecurityException e) {
                System.out.println("Nieco sa pokazilo");
            } catch (NoSuchMethodException e) {
                int i;
            } catch (IllegalArgumentException e) {
                System.out.println("Nieco sa pokazilo");
            } catch (IllegalAccessException e) {
                System.out.println("Nieco sa pokazilo");
            } catch (InvocationTargetException e) {
                System.out.println("Nieco sa pokazilo");
            }
        }
    }
    
    private void posliSpravu(String paSelektor, int paPrvyParameter, int paDruhyParameter) {
        for (Object adresat : aSpravovaneObjekty) {
            try {
                Method sprava = adresat.getClass().getMethod(paSelektor, Integer.TYPE, Integer.TYPE);
                sprava.invoke(adresat, paPrvyParameter, paDruhyParameter);
            } catch (SecurityException e) {
                System.out.println("Nieco sa pokazilo");
            } catch (NoSuchMethodException e) {
                int i;
            } catch (IllegalArgumentException e) {
                System.out.println("Nieco sa pokazilo");
            } catch (IllegalAccessException e) {
                System.out.println("Nieco sa pokazilo");
            } catch (InvocationTargetException e) {
                System.out.println("Nieco sa pokazilo");
            }
        }
    }
    
    /**
     * Vytvori novy manazer, ktory nespravuje zatial ziadne objekty.
     */
    public Manazer() {
        aSpravovaneObjekty = new ArrayList<Object>();
        Platno.dajPlatno().addKeyListener(new ManazerKlaves());
        Platno.dajPlatno().addTimerListener(new ManazerCasovaca());
        Platno.dajPlatno().addMouseListener(new ManazerMysi());
    }
    
    /**
     * Manazer bude spravovat dany objekt.
     */
    public void spravujObjekt(Object paObjekt) {
        aSpravovaneObjekty.add(paObjekt);
    }
    
}
