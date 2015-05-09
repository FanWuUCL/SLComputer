/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.utils;

import slcomputer.views.dialogs.JDialogWait;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Rectangle;
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
    public JWindowWait(){
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
