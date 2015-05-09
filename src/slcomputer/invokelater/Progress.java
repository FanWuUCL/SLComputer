/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.invokelater;

import slcomputer.main.SLComputer;
import slcomputer.views.dialogs.JDialogChest;

/**
 *
 * @author J
 */
public class Progress implements Runnable{
    JDialogChest dialog;
    String report;
    int progress;
    int golden;
    int silver;
    int copper;
    
    public Progress(JDialogChest d, String str, int p, int g, int s, int c){
        dialog=d;
        report=str;
        progress=p;
        golden=g;
        silver=s;
        copper=c;
    }
    
    public void run(){
        if(dialog==null){
            return;
        }
        dialog.progress(report, progress, golden, silver, copper);
    }
}
