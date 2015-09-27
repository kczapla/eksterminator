/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eksterminatorbeta;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author perun
 */
public class Obraz {
    
    /**
     * Konstruktor klasy Obraz, ktory wczytuje sprite sheeta z postaciami do gry
     */
    public Obraz(){
        try {
            image = load.LoadImage("/res/Siatka.png/");
            bgimage =  load.LoadImage("/res/tlo.png/");
        } catch (IOException ex) {
            Logger.getLogger(Obraz.class.getName()).log(Level.SEVERE, null, ex);
        }
        ss = new SpriteSheet(image);
        getTextures();
        
    }
    
    /**
     * Metoda przypisująca konkretną grafikę do pola np. avatar gracza
     * przypisuje do pola player, ktory będzie wykorzystany w klasie gracza
     */
    private void getTextures(){
        player = ss.grabImage(1, 1, 32, 32);
        bullet = ss.grabImage(2, 1, 32, 32);
        enemy1 = ss.grabImage(3, 1, 32, 32);
        enemy2 = ss.grabImage(6, 1, 32, 32);
        enemy3 = ss.grabImage(7, 1, 32, 32);
        
    }
    
    
    
    
    
    public BufferedImage player;
    public BufferedImage bullet;
    public BufferedImage enemy1;
    public BufferedImage enemy2;
    public BufferedImage enemy3;
    
    
    BufferedImage image;
    BufferedImage bgimage;
    ImageLoader load = new ImageLoader();
    SpriteSheet ss;
}
