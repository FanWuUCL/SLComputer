/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.utils;

import slcomputer.views.dialogs.JDialogWait;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import slcomputer.main.SLComputer;

/**
 *
 * @author J
 */
public class JWindowWait  extends Thread{
    public JDialogWait dialog;
    private Object lock;
    public JWindowWait(){
        lock=new Object();
    }
    
    public void run(){
            dialog=new JDialogWait(SLComputer.mf, true);
            dialog.setVisible(true);
    }
    
    public void closeDiag(){
            if(dialog!=null){
                dialog.dispose();
            }
    }
    
}
