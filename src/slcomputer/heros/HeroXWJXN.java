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
public class HeroXWJXN extends Hero{
    public HeroXWJXN(){
        this(1);
    }
    
    public HeroXWJXN(int l){
        super();
        level=l;
        hid=10137;
        id=hid;
        att_born=164;
        def_born=123;
        attGrowth=16.56;
        defGrowth=12.42;
        name="漩涡玖辛奈";
        star=4;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
