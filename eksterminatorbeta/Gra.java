/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eksterminatorbeta;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import javax.swing.JFrame;

/**
 *
 * @author perun
 */
public class Gra extends Canvas implements Runnable {

    public Gra(){
        //wymiary gry
        setMinimumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        setMaximumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        //parametry ramki
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setTitle(TITLE);
        frame.setFocusable(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
                Gra game = new Gra();
                game.start();
    }
    
    /**
     * rozpoczęcie watku
     */
    private synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        
        thread.start();
        
    } 
    /**
     * Zamkniecie watku
     */ 
    private synchronized void stop(){
        if(!running)
            return;
        running = false;
        try{
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
       
        System.exit(1);
    }
    /**
     * funkcja inicujaca poczatkowy stan gry
     */
    public void init(){
        
        requestFocus();
        
        p = new Gracz(100,100,img);
        //e = new Przeciwnik(0,10,img);
        cd = new CentrumDowodzenia(this,img,p);
        cd.createEnemy(enemy_count);
        
        ki = new KeyInput(p, this, cd, img);
    }
    /**
     * Petla gry
     * Ograniczam wartosc 'updatow' do 60 na seksunde
     * oraz rozpoczynam watek gry
     */ 
    public void run(){
        
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60;     //FPS
        double ns = 1000000000/amountOfTicks; // Ile nano seksund jest w tick
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        long now = 0;
        //po uruchomieniu watku
        while(running){
            
            now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1){
                tick();
                updates++;
                delta--;
                
            }
            render();
            frames++;
            if((System.currentTimeMillis()-timer) > 1000){
                timer += 1000;
                System.out.println(updates+" Ticks, Fps "+frames);
                updates = 0;
                frames = 0;
            }
           
        }
        
        stop();
    } 
    
    /**
     * Odswierza paramtery obiektow gry(ruchowe)
     */
    public void tick(){
        
        
        p.tick();
        cd.tick();
        
        if (enemy_killed >= enemy_count){
            enemy_count += 2;
            enemy_killed = 0;
            cd.createEnemy(enemy_count);
        }
        if (lives <= 0){
            
            death = true;
            System.out.println("Warunek Lives");
        }
    }
    
    /**
     * rysuje obiekty gry
     */
    public void render(){
        
       BufferStrategy bs = this.getBufferStrategy(); // 
       if (bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        g.drawImage(image, 0 ,0 ,getWidth(),getHeight(),this);
        g.drawImage(img.bgimage, 0 ,0 ,this);
        
        p.render(g);
        cd.render(g);
        
        //pasek zycia
        g.setColor(Color.gray);
        g.fillRect(5, 5, 200, 25);
        
        g.setColor(Color.red);
        g.fillRect(5, 5, lives, 25);
                
        g.setColor(Color.white);
        g.drawRect(5, 5, 200, 25);
        
        // oblsuga tego co sie stanie po przekroczeniu poizomu zycia 0
        if (lives <= 0){
            
            g.setFont(fnt0);
            g.setColor(Color.black);
            g.drawString("Przegrales",200,200);
            
            g.setFont(fnt1);
            g.setColor(Color.black);
            g.drawString("Nacisnij enter aby zagrac ponownie",150,250);
            
        }
        
        g.dispose();//zwolnienie zasobow systemowych
        bs.show();
        
    }
    /**
     * pole potrzebne do uruchomienia watku
     */
    private boolean death = false;
    private boolean running = false;
    /**
     * pole watku
     */
    private Thread thread;
    public static final String TITLE = "Eksterminator version: beta 1.0";
    public static final int SCALE = 2;
    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH/12*9;
    
    private int enemy_count= 1;
    private int enemy_killed = 0;
    private int lives = 200;
    
    private JFrame frame;
    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,TYPE_INT_RGB);
    private Obraz img = new Obraz();
    private Gracz p;
    private KeyInput ki;
    private Przeciwnik e; 
    private CentrumDowodzenia cd;
    
    private Font fnt0 = new Font("arial", Font.BOLD,50);
    private Font fnt1 = new Font("arial", Font.BOLD,20);

    //getters and setters
    
    /**
     * 
     * @return zwraca wartosc pola enemy count, ktore okresla ilu przeciwnikow 
     * stworzyc
     */
    public int getEnemy_count() {
        return enemy_count;
    }
    /**
     * 
     * @return zwraca wartos Enemy_killed, aby zwiekszac ilosc przeciwnikow
     * na mapie 
     */
    public int getEnemy_killed() {
        return enemy_killed;
    }
    
    public void setEnemy_count(int x) {
        this.enemy_count = x;
    }
    /**
     * 
     * @param enemy_killed ustawia wartosc enemy killed 
     */
    public void setEnemy_killed(int enemy_killed) {
        this.enemy_killed = enemy_killed;
    }
    /**
     * 
     * @return zwraca wartosc pola live, okreslajacego
     * zycie postaci
     */
    public int getLives() {
        return lives;
    }
    /**
     * 
     * @param lives ustawie pole lives
     */
    public void setLives(int lives) {
        this.lives = lives;
    }
    /**
     * 
     * @return zwraca wartosc pola death
     */
    public boolean isDeath() {
        return death;
    }
    /**
     * 
     * @param death ustawia wartosc pola death
     */
    public void setDeath(boolean death) {
        this.death = death;
    }
}
