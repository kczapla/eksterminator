/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eksterminatorbeta;

import eksterminatorbeta.interfejs.InterfaceA;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Klasa reprezentujaca pocisk dziedziczaca po klasie Obiket implementujaca
 * interfejs InterfaceA.
 * @author perun
 */
public class Pocisk extends Obiekt implements InterfaceA {
    /**
     * Kontruktor
     * @param x Wspolrzedna x
     * @param y wspolrzedna y
     * @param cd Obiket klasy centrum dowodzenia, aby uzyskac metody
     * @param img Obiekt klasy Obraz aby otrzymac dostep do przchowywanych obrazow
     */
    public Pocisk(int x, int y, CentrumDowodzenia cd) {
        super(x, y);
        this.cd = cd;
        img = new Obraz();
    }
    /**
     * Upadte parametrow obiketu, predkosc pocisku 10 pix na tick
     * oraz kasowanie pocisku gdy nie osagnie celua doleci na kraniec mapy
     */
    public void tick(){
        y -= 5;
        if (y <= 0){
            cd.removeInterface(this);
        }
    }
    /**
     * rysowanie
     * @param g 
     */
    public void render(Graphics g){
        
        g.drawImage(img.bullet, x, y, null);
        
    }
    //pola
    Obraz img;
    CentrumDowodzenia cd;

    /**
     * Pobiera wartosc x
     * @return zwraca x
     */
    public int getX() {
        return x;
    }
    /**
     * Pobiera wartosc y
     * @return zwraca y
     */
    public int getY() {
        return y;
    }
    /**
     * getter 
     * Overdirve
     * @return zwraca prostokatna otoczke z klasy rodzica
     */
    public Rectangle getBounds() {
        return super.getBounds(32, 32); //To change body of generated methods, choose Tools | Templates.
    }
    
}
