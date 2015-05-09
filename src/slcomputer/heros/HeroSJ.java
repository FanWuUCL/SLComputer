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
public class HeroSJ extends Hero{
    public HeroSJ(){
        this(1);
    }
    
    public HeroSJ(int l){
        super();
        level=l;
        hid=10157;
        id=hid;
        att_born=94;
        def_born=125;
        attGrowth=9.49;
        defGrowth=12.63;
        name="手鞠";
        star=3;
        style=3;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
