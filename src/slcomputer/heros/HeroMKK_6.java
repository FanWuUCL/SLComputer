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
public class HeroMKK_6 extends HeroMKK{
    public HeroMKK_6(){
        this(1);
    }
    
    public HeroMKK_6(int l){
        super();
        level=l;
        hid=10118;
        id=hid+2000;
        att_born=173;
        def_born=130;
        attGrowth=17.47;
        defGrowth=13.13;
        name="迈克.凯";
        star=4;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
