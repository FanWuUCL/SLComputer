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
public class HeroLZ_5 extends HeroLZ{
    public HeroLZ_5(){
        this(1);
    }
    
    public HeroLZ_5(int l){
        super();
        level=l;
        hid=10181;
        id=hid+1000;
        att_born=110;
        def_born=147;
        attGrowth=11.11;
        defGrowth=14.85;
        name="老紫";
        star=4;
        style=2;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
