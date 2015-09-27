/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eksterminatorbeta;

import eksterminatorbeta.interfejs.InterfaceA;
import eksterminatorbeta.interfejs.InterfaceB;


/**
 * Klasa sprawdzajaca czy nastpila kolizja pomiedzy obiketami
 * @author perun
 */
public class Kolizja {
    
    /**
     * Metoda sprawdzajaca czy prostokatne obwodki tkore otaczaja obiekt daniej 
     * klasy nachodza na siebie. Metoda porownuje obiekty klasy pocisk i enemy
     * @param ia obiket implemetujacy interfejs InterfaceA
     * @param ib obiket inmplementujacy interfejs InterfaceB
     * @return zwraca wartos true kiedy obiekty nachodza na siebie, false 
     * w przeciwnym wypadku
     */
    public static boolean is_colision(InterfaceA ia, InterfaceB ib){
        
        if (ia.getBounds().intersects(ib.getBounds())){
            return true;
        }
        
        return false;
    } 
    /**
     * Metoda sprawdzajaca czy prostokatne obwodki tkore otaczaja obiekt daniej 
     * klasy nachodza na siebie. Metoda ta porownuje obikety klasy gracz i enemy
     * @param p obiket klasy gracz 
     * @param ib obiket inmplementujacy interfejs InterfaceB
     * @return zwraca wartos true kiedy obiekty nachodza na siebie, false 
     * w przeciwnym wypadku
     */
    public static boolean is_colision(Gracz p, InterfaceB ib){
        
        if (p.getBounds().intersects(ib.getBounds())){
            return true;
        }
        
        return false;
    } 
   
    
}
