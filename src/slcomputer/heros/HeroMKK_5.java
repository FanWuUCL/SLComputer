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
public class HeroMKK_5 extends HeroMKK{
    public HeroMKK_5(){
        this(1);
    }
    
    public HeroMKK_5(int l){
        super();
        level=l;
        hid=10118;
        id=hid+1000;
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
