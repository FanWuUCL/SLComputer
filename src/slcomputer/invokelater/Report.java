/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.invokelater;

import slcomputer.main.SLComputer;
import slcomputer.views.dialogs.JDialogAutoProgress;

/**
 *
 * @author J
 */
public class Report implements Runnable{
    private JDialogAutoProgress dialogProgress;
    private String report;
    private boolean status;
    
    public Report(JDialogAutoProgress p, String s, boolean t){
        dialogProgress=p;
        report=s;
        status=t;
    }
    
    public void run(){
        SLComputer.log(report);
        if(dialogProgress==null){
            return;
        }
        dialogProgress.append(report);
        if(!status){
            dialogProgress.setStop();
        }
    }
}
