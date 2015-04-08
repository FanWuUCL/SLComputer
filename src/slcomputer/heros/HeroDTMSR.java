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
public class HeroDTMSR extends Hero{
    public HeroDTMSR(){
        this(1);
    }
    
    public HeroDTMSR(int l){
        super();
        level=l;
        hid=10326;
        id=hid;
        name="大筒木舍人";
    }
}
