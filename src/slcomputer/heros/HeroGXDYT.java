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
public class HeroGXDYT extends Hero{
    public HeroGXDYT(){
        this(1);
    }
    
    public HeroGXDYT(int l){
        super();
        level=l;
        hid=10210;
        id=hid;
        att_born=74;
        def_born=99;
        attGrowth=7.96;
        defGrowth=10.64;
        name="鬼兄弟业头";
        star=2;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }    
}
