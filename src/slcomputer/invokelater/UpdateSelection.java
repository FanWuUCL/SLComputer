/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.invokelater;

import slcomputer.main.SLComputer;
import slcomputer.runnable.SocketMaster;

/**
 *
 * @author J
 */
public class UpdateSelection implements Runnable{
    public int mode;
    public int level;
    public int buffHPP;
    public int buffHPM;
    public int buffEffectP;
    public int buffEffectM;
    public int buffKill;
    public int enemyHard;
    public int enemyNorm;
    public int enemyEasy;
    public int myNumber;
    public int enemyNumber;
    public String battle;
    public boolean win;
    
    public UpdateSelection(){
        mode=1;
        level=1;
        buffHPP=0;
        buffHPM=0;
        buffEffectP=0;
        buffEffectM=0;
        buffKill=0;
        enemyHard=1;
        enemyNorm=1;
        enemyEasy=1;
        myNumber=1;
        enemyNumber=1;
        battle="";
        win=true;
    }
    
    @Override
    public void run(){
        SLComputer.mf.setMode(mode);
        SLComputer.mf.setLevel(level);
        SLComputer.mf.setBuff(buffHPP, buffHPM, buffEffectP, buffEffectM, buffKill>0);
        SLComputer.mf.setEnemy(enemyHard, enemyNorm, enemyEasy);
        SLComputer.mf.setNumbers(myNumber, enemyNumber);
        if(!SLComputer.watchBattle && win){
            SLComputer.mf.finalComputer(SocketMaster.bbType);
        }
        else{
            SLComputer.mf.setDetails(battle);
        }
    }
}
