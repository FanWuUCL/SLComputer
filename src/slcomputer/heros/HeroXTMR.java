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
public class HeroXTMR extends Hero{
    public HeroXTMR(){
        this(1);
    }
    
    public HeroXTMR(int l){
        super();
        level=l;
        hid=10321;
        id=hid;
        name="仙体鸣人";
    }
}
