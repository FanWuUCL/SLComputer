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
public class HeroSMTT extends Hero{
    public HeroSMTT(){
        this(1);
    }
    
    public HeroSMTT(int l){
        super();
        level=l;
        hid=10243;
        id=hid;
        name="水门太太";
    }
}
