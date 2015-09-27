/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eksterminatorbeta;

import eksterminatorbeta.interfejs.InterfaceB;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * Klasa przeciwnika, określa paramtery ruchu oraz rysowania jego grafiki;
 * @author perun
 */
public class Przeciwnik extends Obiekt implements InterfaceB {

    
   
    /**
     * Kosntuktor klasy przeciwnika
     * @param x wsporzedna x przeciwnika
     * @param y wspolrzedna y przeciwnika
     * @param img aby mozna bylo korzystac z pol obiektu Obraz, w ktorym
     * znajduja sie wczytane tekstury 
     */
   
    public Przeciwnik(int x, int y, Obraz img){
        super(x,y);
        this.img = img;
        
    }

    /**
     * odswiezanie informacji o polozeniu przeciwnika
     */
    public void tick() {
        
        y += SPEED; //SPEED;
        
        
        if (y>=Gra.HEIGHT*Gra.SCALE){
            y = 0;
            x = r.nextInt(640);
        }
    }

    /**
     * Rysowanie przeciwnika, oraz wybor tekstury ktora zostanie wczytana i bedzie
     * reprezentowac obiekt przeciwnika w oknie gry
     * @param g 
     */
    public void render(Graphics g) {
        
        if(whichEnemy == 0){
            g.drawImage(img.enemy1, x, y, null);
        }
        else if(whichEnemy == 1){
            g.drawImage(img.enemy2, x, y, null);
        }
        else if( whichEnemy == 2){
            g.drawImage(img.enemy3, x, y, null);
        }
            
    }
    
    Obraz img;
    Random r = new Random();
    
    private int SPEED = r.nextInt(4)+1; 
    private int StartPosition = r.nextInt(640);
    private int whichEnemy = r.nextInt(3);

    /**
     * getter
     * @return polozenie x
     */
    public int getX() {
        return x;
    }

    /**
     * getter
     * @return polozenie y 
     */
    public int getY() {
        return y;
    }
    /**
     * Overdrive: metode z klasy rodzica
     * @return zwraca prostokatna otoczke
     */
    public Rectangle getBounds() {
        return super.getBounds(32, 32); //To change body of generated methods, choose Tools | Templates.
    }

}
