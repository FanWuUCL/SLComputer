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
public class HeroRXCT extends Hero{
    public HeroRXCT(){
        this(1);
    }
    
    public HeroRXCT(int l){
        super();
        level=l;
        hid=10162;
        id=hid;
        att_born=122;
        def_born=92;
        attGrowth=12.32;
        defGrowth=9.29;
        name="日向雏田";
        star=3;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
