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
public class HeroBMK extends Hero{
    public HeroBMK(){
        this(1);
    }
    
    public HeroBMK(int l){
        super();
        level=l;
        hid=10251;
        id=hid;
        name="八门凯";
    }
}
