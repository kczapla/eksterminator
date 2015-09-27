/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eksterminatorbeta.interfejs;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Interfejs sluzacy do wykrywania kolizji pomiedzy klasami 
 *  
 * 
 * @see "Java Podstawy" wydanie VII Cay S. Horstmann, Garry Cornell, str.279 
 * Rozdział 6, podrozdział "Wlasnosci interfejsow"
 * @author perun
 */
public interface InterfaceA {
    /**
     * @see eksterminatorbeta.InterfaceB#tick()
     */
    public void tick();
    /**
     * @see eksterminatorbeta.InterfaceB#render(Graphics)
     * @param g 
     */
    public void render(Graphics g);
    /**
     * @see eksterminatorbeta.InterfaceB#getBounds(int,int)
     * @return 
     */
    public Rectangle getBounds();
    
    /**
     * @see eksterminatorbeta.InterfaceB#getX()
     * @return 
     */
    public int getX();
    /**
     * @see eksterminatorbeta.InterfaceB#getY
     * @return 
     */
    public int getY();
    
}
