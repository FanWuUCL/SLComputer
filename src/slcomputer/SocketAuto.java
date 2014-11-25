/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer;

import slcomputer.dialogs.JDialogAutoProgress;

/**
 *
 * @author J
 */
public class SocketAuto implements Runnable{
    private JDialogAutoProgress dialogProgress;
    
    private int maxLevel;
    private int rate;
    private int HPPTarget;
    private int HPPMax;
    private int HPMTarget;
    private int HPMMax;
    private int EffectPTarget;
    private int EffectPMax;
    private int EffectMTarget;
    private int EffectMMax;
    
    public void setParameters(int level, int r, int hppt, int hppm, int hpmt, int hpmm, int ept, int epm, int emt, int emm){
        maxLevel=level;
        rate=r;
        HPPTarget=hppt;
        HPPMax=hppm;
        HPMTarget=hpmt;
        HPMMax=hpmm;
        EffectPTarget=ept;
        EffectPMax=epm;
        EffectMTarget=emt;
        EffectMMax=emm;
    }
    
    @Override
    public void run(){
        
    }
}
