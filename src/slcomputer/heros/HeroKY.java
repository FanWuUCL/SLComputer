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
public class HeroKY extends Hero{
    public HeroKY(){
        this(1);
    }
    
    public HeroKY(int l){
        super();
        level=l;
        hid=10261;
        id=hid;
        name="蛞蝓";
    }
}
