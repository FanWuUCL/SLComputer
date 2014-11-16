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
public class HeroYFASM_6 extends HeroYFASM{
    public HeroYFASM_6(){
        this(1);
    }
    
    public HeroYFASM_6(int l){
        super();
        level=l;
        hid=10115;
        id=hid+2000;
        att_born=150;
        def_born=113;
        attGrowth=15.15;
        defGrowth=11.41;
        name="猿飞阿斯玛";
        star=4;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
