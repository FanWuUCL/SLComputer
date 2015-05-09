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
public class HeroSMTT_6 extends HeroSMTT{
    public HeroSMTT_6(){
        this(1);
    }
    
    public HeroSMTT_6(int l){
        super();
        level=l;
        hid=10243;
        id=hid+1000;
        name="水门太太";
    }
}
