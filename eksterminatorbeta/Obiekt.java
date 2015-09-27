/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eksterminatorbeta;

import java.awt.Rectangle;

/**
 * Klasa po ktorej beda dzieciczyly klasy gracza, przeciwnika oraz pocisku
 * aby zaoszczedzic czas i nie pisac po kilka razy tych samych pol i metod
 * @author perun
 */
public class Obiekt {
    
    Obiekt(int x, int y){
        
        this.x = x;
        this.y = y;
        
    }
    /**
     * Metoda tworzaca porstaktne pole wokolo obiketu, ktory sluzy przy wykryciu 
     * kolizji
     * @param width szerokosc obiektu
     * @param height wysokosc obiektu
     * @return zwraca prostokatna obwodke
     */
    public Rectangle getBounds(int width, int height){
        return new Rectangle(x,y, width, height);
    }
    
    //polozenie obiektow 
    public int x;
    public int y;
    
}
