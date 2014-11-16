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
public class HeroHTX extends Hero{
    public HeroHTX(){
        this(1);
    }
    
    public HeroHTX(int l){
        super();
        level=l;
        hid=10292;
        id=hid;
        name="秽土蝎";
    }
}
