/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import slcomputer.Hero;

/**
 *
 * @author J
 */
public class HeroDHMXR extends Hero{
    public HeroDHMXR(){
        this(1);
    }
    
    public HeroDHMXR(int l){
        super();
        level=l;
        hid=10302;
        id=hid;
        name="大蛤蟆仙人";
    }
}
