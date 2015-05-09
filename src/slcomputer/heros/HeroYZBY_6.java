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
public class HeroYZBY_6 extends HeroYZBY{
    public HeroYZBY_6(){
        this(1);
    }
    
    public HeroYZBY_6(int l){
        super();
        level=l;
        hid=10104;
        id=11104;
        att_born=211;
        def_born=163;
        attGrowth=22.16;
        defGrowth=17.12;
        name="宇智波鼬";
        star=5;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
