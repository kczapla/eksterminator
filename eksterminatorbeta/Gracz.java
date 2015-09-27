/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eksterminatorbeta;


import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Klasa gracza, obsluga ruchu, wyswietlanie avatara
 * @author perun
 */
public class Gracz extends Obiekt {

    public Gracz(int x, int y, Obraz img) {
        super(x, y);
        this.img = img;
    }
    
    /**
     * odswiezanie parametrow klasy gracz
     */
    public void tick(){
        
        x += valX;
        y += valY;
        
        if (x <= 0)
            x = 0;
        if (x >= 608)
            x = 608;
        if (y <= 0)
            y = 0;
        if (y >= 448)
            y = 448;
    }
    /**
     * Rysowanie obiektow gracza
     * @param g wie kiedy ma narysowac
     */
    public void render(Graphics g){
        
        g.drawImage(img.player, x, y, null);
        
    }
    
    private int valX = 0;
    private int valY = 0;
    Obraz img;

    /**
     * Setter, ustala predkosc prouszania sie obiektu gracza w plaszczyznie x
     * @param valX 
     */
    public void setValX(int valX) {
        this.valX = valX;
    }
    /**
     * setter stala predkosc prouszania sie obiektu gracza w plaszczyznie y
     * @param valY 
     */
    public void setValY(int valY) {
        this.valY = valY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    /**
     * getter
     * ovedrive: metode z klasy rodzica
     * 
     * @return zwraca prostokatna otoczke wokol obiektu 
     */
    public Rectangle getBounds() {
        return super.getBounds(32, 32); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
