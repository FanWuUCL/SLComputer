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
public class HeroSC extends Hero{
    public HeroSC(){
        this(1);
    }
    
    public HeroSC(int l){
        super();
        level=l;
        hid=10180;
        id=hid;
        att_born=118;
        def_born=157;
        attGrowth=11.92;
        defGrowth=15.86;
        name="矢仓";
        star=4;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
