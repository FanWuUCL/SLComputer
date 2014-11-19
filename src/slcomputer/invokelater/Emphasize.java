/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.invokelater;

import slcomputer.SLComputer;
import slcomputer.SLComputer;

/**
 *
 * @author J
 */
public class Emphasize implements Runnable{
    
    public boolean emph;
    
    public Emphasize(boolean e){
        emph=e;
    }
    
    @Override
    public void run(){
        SLComputer.mf.emphasizeBattleButtons(emph);
    }
}
