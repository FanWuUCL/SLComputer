/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.invokelater;

import slcomputer.main.SLComputer;
import slcomputer.main.SLComputer;
import slcomputer.runnable.SocketMaster;

/**
 *
 * @author J
 */
public class Emphasize implements Runnable{
    
    public boolean emph;
    public boolean loggedin;
    public String usrName;
    
    public Emphasize(boolean l, boolean e){
        loggedin=l;
        emph=e;
        usrName="";
    }
    
    @Override
    public void run(){
        SLComputer.mf.emphasizeBattleButtons(loggedin&&emph);
        SLComputer.mf.enableAutoBB(loggedin, emph);
        String title=SLComputer.mf.getTitle();
        int index=title.indexOf("(");
        if(!loggedin){
            SLComputer.mf.setSmartNumber(SLComputer.smartNumber_bk);
            if(index>=0){
                SLComputer.mf.setTitle(title.substring(0, index-1));
            }
        }
        else{
            SLComputer.mf.setSmartNumber(true);
            if(index<0){
                SLComputer.mf.setTitle(SLComputer.mf.getTitle()+" ("+SocketMaster.globalName+" 已登陆)");
            }
        }
    }
}
