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
public class HeroSWRZL_6 extends HeroSWRZL{
    public HeroSWRZL_6(){
        this(1);
    }
    
    public HeroSWRZL_6(int l){
        super();
        level=l;
        hid=10217;
        id=hid+1000;
        att_born=260;
        def_born=195;
        attGrowth=33.8;
        defGrowth=21.45;
        name="十尾人柱力";
        star=5;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=11;
    }
}
