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
public class HeroFu_6 extends HeroFu{
    public HeroFu_6(){
        this(1);
    }
    
    public HeroFu_6(int l){
        super();
        level=l;
        hid=10184;
        id=hid+2000;
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
