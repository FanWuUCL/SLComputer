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
public class HeroMRTT_6 extends HeroMRTT{
    public HeroMRTT_6(){
        this(1);
    }
    
    public HeroMRTT_6(int l){
        super();
        level=l;
        hid=10242;
        id=hid+1000;
        name="鸣人太太";
    }
}
