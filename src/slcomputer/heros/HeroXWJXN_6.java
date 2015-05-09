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
public class HeroXWJXN_6 extends HeroXWJXN{
    public HeroXWJXN_6(){
        this(1);
    }
    
    public HeroXWJXN_6(int l){
        super();
        level=l;
        hid=10137;
        id=hid+2000;
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
