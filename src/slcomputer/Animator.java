/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author J
 */
public class Animator extends JFrame implements Runnable{
    Thread amtThread;
    ImageIcon imageIcon;
    int w=519;
    int h=330;
    boolean dreaming;
    Animator(){
        super();
        dreaming=SLComputer.dreamMode;
        if(dreaming){
            imageIcon=new ImageIcon("TP/dreaming90.png");
        }
        else{
            imageIcon=new ImageIcon("TP/dreaming0.png");
        }
        Rectangle b=SLComputer.mf.getBounds();
        setPreferredSize(new Dimension(w, h));
        setBounds(b.x+b.width/2-w/2, b.y+b.height/2-h/2, w, h);
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        JPanel p = new JPanel() { 
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                //继承超类绘制组件方法
                Graphics2D gg=(Graphics2D)g; 
                if(imageIcon!= null) {
                    gg.drawImage(imageIcon.getImage(), 0, 0, getWidth(),  getHeight(), this);  
                } 
            }  
        };  
        p.setLayout(null); 
        setContentPane(p);
        com.sun.awt.AWTUtilities.setWindowOpaque(this, false);
        pack();
        setVisible(true);
        amtThread=new Thread(this);
        amtThread.start();
    }
    
    public void run(){
        int i;
        if(dreaming){
            for(i=270; i<730; i+=10){
                imageIcon=new ImageIcon("TP/dreaming"+(i%360>180?360-i%360:i%360)+".png");
                repaint();
                try {
                    Thread.sleep(i/10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            for(i=20; i>0; i--){
                com.sun.awt.AWTUtilities.setWindowOpacity(this, i/20.0f);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else{
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Animator.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(i=1; i<27; i++){
                imageIcon=new ImageIcon("TP/simple"+i+".png");
                repaint();
                try {
                    Thread.sleep(35);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Animator.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(i=20; i>0; i--){
                com.sun.awt.AWTUtilities.setWindowOpacity(this, i/20.0f);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        dispose();
    }
}
