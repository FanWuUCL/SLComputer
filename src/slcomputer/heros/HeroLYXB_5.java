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
public class HeroLYXB_5 extends HeroLYXB{
    public HeroLYXB_5(){
        this(1);
    }
    
    public HeroLYXB_5(int l){
        super();
        level=l;
        hid=10233;
        id=hid+1000;
        att_born=175;
        def_born=131;
        attGrowth=17.68;
        defGrowth=13.23;
        name="狼牙雪崩";
        star=4;
        style=9;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
