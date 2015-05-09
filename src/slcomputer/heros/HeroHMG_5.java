/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import slcomputer.computer.Team;

/**
 *
 * @author J
 */
public class HeroHMG_5 extends HeroHMG{
    public HeroHMG_5(){
        this(1);
    }
    
    public HeroHMG_5(int l){
        super();
        level=l;
        hid=10265;
        id=hid+1000;
        name="蛤蟆广";
    }
}
