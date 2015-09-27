/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eksterminatorbeta;

import eksterminatorbeta.interfejs.InterfaceA;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**
 * Klasa obsługująca klawiaturę, czyli sterowanie postacią gracza
 * @author perun
 */
public class KeyInput extends KeyAdapter {
    
    /**
     * Pobieranie obiketu klasy player oby bylo mozliwe modyfikowanie jego 
     * parametrow ruchu z klas KeyInput
     * @param p 
     */
    public KeyInput(Gracz p, Gra gra, CentrumDowodzenia cd, Obraz img){
        this.p = p;
        this.cd = cd;
        this.img = img;
        this.gra = gra;
        gra.addKeyListener(this);
        //System.out.println("KeyInput konstruktor");
    }
    
    /**
     * Obsluga przycisnieca kalwisza
     * @param e wykrycie akcji kalwisza
     * UWAGA! Funkcje nie dziaja dobrze pod systemami Linux
     * @see <a href="http://bugs.sun.com/view_bug.do?bug_id=4153069">Bug report</a>
     */
    public void keyPressed(KeyEvent e){
        
        int key = e.getKeyCode();
        if(!gra.isDeath()){
            if (key == KeyEvent.VK_RIGHT){
                p.setValX(5);
            }
            else if (key == KeyEvent.VK_LEFT){
                p.setValX(-5);
            }
            else if (key == KeyEvent.VK_UP){
                p.setValY(-5);
            }
            else if (key == KeyEvent.VK_DOWN){
                p.setValY(5);
            }
            if (key == KeyEvent.VK_SPACE){
                if(!is_shooting){
                    cd.addInterface(new Pocisk(p.getX(), p.getY(), cd));
                    is_shooting = true;
                    
                }
            }
        }
        if (key == KeyEvent.VK_ENTER){
            gra.setLives(200);
            gra.setDeath(false);
            gra.setEnemy_count(1);
            gra.init();
        }
    }
    /**
     * Obsluga zwolnienia kalwisza
     * @param e wykrycie akcji kalwisza
     */
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_RIGHT){
            p.setValX(0);
        }
        else if (key == KeyEvent.VK_LEFT){
            p.setValX(0);
        }
        else if (key == KeyEvent.VK_UP){
            p.setValY(0);
        }
        else if (key == KeyEvent.VK_DOWN){
            p.setValY(0);
        }
        if (key == KeyEvent.VK_SPACE){
            is_shooting = false;
        }
        if (key == KeyEvent.VK_ENTER){
            
        }
    }
    
    private boolean is_shooting = false;
    
    private Gracz p;
    private Pocisk b;
    private LinkedList<InterfaceA> ia;
    private CentrumDowodzenia cd;
    private Obraz img;
    private Gra gra;
}
