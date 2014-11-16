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
public class HeroXRMR extends Hero{
    public HeroXRMR(){
        this(1);
    }
    
    public HeroXRMR(int l){
        super();
        level=l;
        hid=10301;
        id=hid;
        name="仙人鸣人";
    }
}
