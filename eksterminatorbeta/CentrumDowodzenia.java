/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eksterminatorbeta;

import eksterminatorbeta.interfejs.InterfaceA;
import eksterminatorbeta.interfejs.InterfaceB;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

/**
 * Klasa sterujaca tworzeniem przeciwnikow, pociskow oraz sprawdzaniem wystepownia 
 * kolizji pomiedzy obiektami
 * @author perun
 */
public class CentrumDowodzenia {
    /**
     * Kontruktor klasy Centrum dowodzenia
     * @param img aby miec dostep do pol obiketu Klasy img w ktorej przechowywane
     * sa tekstury 
     * @param metody get i setter 
     */
    public CentrumDowodzenia(Gra game, Obraz img, Gracz p){
        
        this.game = game;
        this.img = img;
        this.p = p;
        
        
        
    }
    /**
     * metoda tworzaca przeciwnikow
     * @param enemy_count okresla ile przeciwnikow nalezy utworzyc
     * nastepnie stworznych przecinikow dodaje do listy
     */
    public void createEnemy(int enemy_count){
        for (int i = 0; i < enemy_count; i++){
            ib.add(new Przeciwnik(r.nextInt(Gra.WIDTH*Gra.SCALE),10,img));
        }
    }
    
    /**
     * Odswizanie parametrow obiektow znajdujacych sie liscie
     * sprawdza czy pomiedzy roznymi interfejsami nie dochodzi do kolizji
     * obiekt znajdujca sie pod numerem i jest przypisywany do zmiennej temp
     * a nastepnie realizowana jest funkcja tick obiketu
     * 
     */
    public void tick(){
        //wrog, interfaceB
        for(int i = 0; i < ib.size(); i++ ){
            tempB = ib.get(i);
            tempB.tick();
        }
        //pocisk, interfaceA
        for(int i = 0; i < ia.size(); i++ ){
            tempA = ia.get(i);
            tempA.tick();
        }
        /* petla wykrywania kolizji  sprawdza sie czy dla danego przeciwnika, ktory ryje sie pod i
        nie nachodzi pocisk, gdzie sprawdzane jest to w petli drugiej, ktroa przechodzi przez liste
        pociskow. Jesli wystepuje kolizja nastpuje kasowanie pocisku oraz przeciwnika*/
        for(int i = 0; i < ib.size(); i++){
            tempB = ib.get(i);
            if ((Kolizja.is_colision(p, tempB))){
                game.setLives(game.getLives()-1);
                System.out.println("CentrumDowowdzenia petla kolizji  "+game.getLives());
            }
            //System.out.println("CentrumDowowdzenia pentla kolizji "+ib.size());
            for(int j = 0; j < ia.size(); j++){
                tempA = ia.get(j);
                //System.out.println("2CentrumDowowdzenia pentla kolizji "+ia.size());
                if(Kolizja.is_colision(tempA, tempB)){
                    ib.remove(i);
                    ia.remove(j);
                    game.setEnemy_killed(game.getEnemy_killed()+1);
                    //System.out.println("CentrumDowowdzenia pentla kolizji "+ile_zniszczonych);
                }
                //break;
            }
            continue; // patla zaczyna sie od nowa z nowymi parametrami listy
        }
    }
    /**
     * rysowania obiektow przechowywanych w liscie
     * @param g 
     * obiekt znajdujca sie pod numerem i jest przypisywany do zmiennej temp
     * a nastepnie realizowana jest funkcja render dla danego obiektu w liscie 
     */
    public void render(Graphics g){
        // wrog, interfaceB
        for(int i = 0; i < ib.size(); i++ ){
            tempB = ib.get(i);
            tempB.render(g);
        }
        // wrog, interfaceB
        for(int i = 0; i < ia.size(); i++ ){
            tempA = ia.get(i);
            tempA.render(g);
        }
    }
    /**
     * Dodaje kolejeny obiekt do listy
     * @param block 
     */
    public void addInterface(InterfaceA block){
        ia.add(block);
    }
    
    public void removeInterface(InterfaceA block){
        ia.remove(block);
    }
    
    
    
    Obraz img;
    
    private LinkedList<InterfaceA> ia = new LinkedList<InterfaceA>(); 
    private LinkedList<InterfaceB> ib = new LinkedList<InterfaceB>(); 
    
    
    private InterfaceA tempA;
    private InterfaceB tempB;
    //private InterfaceC tempC;
    private Gra game;
    private Gracz p;
    
    Random r = new Random();
    
    private boolean is_colision;
    //public int ile_zniszczonych = 0;
    
    
}
