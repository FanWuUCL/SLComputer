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
public class HeroSHGJ_6 extends HeroSHGJ{
    public HeroSHGJ_6(){
        this(1);
    }
    
    public HeroSHGJ_6(int l){
        super();
        level=l;
        hid=10255;
        id=hid+1000;
        name="鲨化鬼鲛";
    }
}
