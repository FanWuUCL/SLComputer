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
public class HeroSHGJ extends Hero{
    public HeroSHGJ(){
        this(1);
    }
    
    public HeroSHGJ(int l){
        super();
        level=l;
        hid=10255;
        id=hid;
        name="鲨化鬼鲛";
    }
}
