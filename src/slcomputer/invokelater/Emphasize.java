/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.invokelater;

import slcomputer.SLComputer;
import slcomputer.SLComputer;
import slcomputer.SocketMaster;

/**
 *
 * @author J
 */
public class Emphasize implements Runnable{
    
    public boolean emph;
    public String usrName;
    
    public Emphasize(boolean e){
        emph=e;
        usrName="";
    }
    
    @Override
    public void run(){
        SLComputer.mf.emphasizeBattleButtons(emph);
        SLComputer.mf.enableAutoBB(emph);
        if(!emph){
            SLComputer.mf.setSmartNumber(SLComputer.smartNumber_bk);
            String title=SLComputer.mf.getTitle();
            int index=title.indexOf("(");
            if(index>=0){
                SLComputer.mf.setTitle(title.substring(0, index-1));
            }
        }
        else{
            SLComputer.mf.setSmartNumber(true);
            SLComputer.mf.setTitle(SLComputer.mf.getTitle()+" ("+SocketMaster.globalName+" 已登陆)");
        }
    }
}
