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
public class HeroDXBY_5 extends HeroDXBY{
    public HeroDXBY_5(){
        this(1);
    }
    
    public HeroDXBY_5(int l){
        super();
        level=l;
        hid=10235;
        id=hid+1000;
        att_born=170;
        def_born=128;
        attGrowth=17.17;
        defGrowth=12.93;
        name="冬熊冰雨";
        star=4;
        style=9;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
