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
public class HeroMRTT extends Hero{
    public HeroMRTT(){
        this(1);
    }
    
    public HeroMRTT(int l){
        super();
        level=l;
        hid=10242;
        id=hid;
        name="鸣人太太";
    }
}
