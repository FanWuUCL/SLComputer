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
public class HeroHMG extends Hero{
    public HeroHMG(){
        this(1);
    }
    
    public HeroHMG(int l){
        super();
        level=l;
        hid=10265;
        id=hid;
        name="蛤蟆广";
    }
}
