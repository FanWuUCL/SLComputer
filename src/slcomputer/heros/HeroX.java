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
public class HeroX extends Hero{
    public HeroX(){
        this(1);
    }
    
    public HeroX(int l){
        super();
        level=l;
        hid=10133;
        id=hid;
        att_born=130;
        def_born=173;
        attGrowth=13.13;
        defGrowth=17.47;
        name="蝎";
        star=4;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
