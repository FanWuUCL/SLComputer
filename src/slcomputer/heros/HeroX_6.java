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
public class HeroX_6 extends HeroX{
    public HeroX_6(){
        this(1);
    }
    
    public HeroX_6(int l){
        super();
        level=l;
        hid=10133;
        id=hid+2000;
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
