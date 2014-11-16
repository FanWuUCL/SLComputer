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
public class HeroTT extends Hero{
    public HeroTT(){
        this(1);
    }
    
    public HeroTT(int l){
        super();
        level=l;
        hid=10167;
        id=hid;
        att_born=120;
        def_born=90;
        attGrowth=12.12;
        defGrowth=9.09;
        name="天天";
        star=3;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
