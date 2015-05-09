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
public class HeroFu extends Hero{
    public HeroFu(){
        this(1);
    }
    
    public HeroFu(int l){
        super();
        level=l;
        hid=10184;
        id=hid;
        att_born=115;
        def_born=153;
        attGrowth=11.62;
        defGrowth=15.45;
            name="芙";
        star=4;
        style=8;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
