/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eksterminatorbeta;

import java.awt.image.BufferedImage;

/**
 *
 * @author perun
 */
public class SpriteSheet {
    
    /**
     * 
     * @param image obraz do obróbki
     */
    SpriteSheet(BufferedImage image){
        
        this.image = image;
    }
    /**
     * Metoda do wybierania obrazu z SS
     * @param col kolumna w ktorej się znajduje sprite sheet
     * @param row rzad w ktorym znajduje sie sprite sheet
     * @param width szerokosc danej tekstury
     * @param height wysokosc
     * @return uzyskany obraz
     */
    public BufferedImage grabImage(int col, int row, int width, int height){
        BufferedImage img =  image.getSubimage(32*col-32, 32*row-32, width, height);
        return img;
    }
    
    BufferedImage image;
}
