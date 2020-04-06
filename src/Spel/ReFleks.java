package Spel;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
  
public class ReFleks extends Applet implements MouseListener {
  
    long start, end, randomTime;
    boolean started = false;
    boolean cheat;
    String info;
    String reactionTime = "Klicka för att se din reaktionstid! ";
     
    public void init() {
        addMouseListener(this);
        this.setSize(600, 300);
        
    }
     
    public void timer() {
        started = true;        
        start = System.currentTimeMillis();                                       // Startar timer
        randomTime = Math.round(Math.random() * 5000) + 1000;                     // anger en random spawntid
        try {
            Thread.sleep(randomTime);            
        }
        catch(InterruptedException e) {}                                          
         
    }
  
    public void paint(Graphics g)  {
    	
        g.drawString("" + reactionTime, 120, 60);
        g.drawRect(71, 35, 37, 37);
        if (started) {
            g.setColor(Color.red);
            g.fillRect(72, 36, 36, 36);
        } 
        else {            
            g.setColor(Color.green);
            g.fillRect(72, 36, 36, 36);              
        }
        
    }
     
    public void mousePressed(MouseEvent e) {
        if (started) {              
            started = false;
            end = System.currentTimeMillis();
            if (end < (start + randomTime)) {
                reactionTime = "Du fuskade! Klicka för att börja om.";
                cheat = true;
            } else {
                reactionTime = "Din reaktionstid är " + (end - (start + randomTime)) + " Millisekunder. Klicka för att starta om";
            }               
        } else {
            cheat = false;
            timer();
      
        }
        
        repaint();
    }    
     
    public void mouseMoved(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}