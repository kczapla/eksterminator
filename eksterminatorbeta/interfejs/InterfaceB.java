/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eksterminatorbeta.interfejs;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @see eksterminatorbeta.InterfaceA#InterfaceA
 * @author perun
 */
public interface InterfaceB {
    /**
     * update
     */
    public void tick();
    /**
     * Rysowanie
     * @param g 
     */
    public void render(Graphics g);
    /**
     * Prostokatna otoczke wokol obiektu
     * @return zwraca otoczke
     */
    public Rectangle getBounds();
    /**
     * getter
     * @return wspolrzedna x
     */
    public int getX();
    /**
     * getter
     * @return wspolrzedna y
     */
    public int getY();
}
