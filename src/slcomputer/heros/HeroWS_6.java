/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import slcomputer.Hero;
import slcomputer.Team;

/**
 *
 * @author J
 */
public class HeroWS_6 extends HeroWS{
    public HeroWS_6(){
        this(1);
    }
    
    public HeroWS_6(int l){
        super();
        level=l;
        hid=10260;
        id=hid+1000;
        name="万蛇";
    }
}
