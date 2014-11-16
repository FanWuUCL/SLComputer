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
public class HeroHMG_6 extends HeroHMG{
    public HeroHMG_6(){
        this(1);
    }
    
    public HeroHMG_6(int l){
        super();
        level=l;
        hid=10265;
        id=hid+2000;
        name="蛤蟆广";
    }
}
