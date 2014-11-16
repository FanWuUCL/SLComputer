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
public class HeroHMJ extends Hero{
    public HeroHMJ(){
        this(1);
    }
    
    public HeroHMJ(int l){
        super();
        level=l;
        hid=10266;
        id=hid;
        name="蛤蟆健";
    }
}
