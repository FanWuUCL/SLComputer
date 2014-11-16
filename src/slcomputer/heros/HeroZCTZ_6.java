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
public class HeroZCTZ_6 extends HeroZCTZ{
    public HeroZCTZ_6(){
        this(1);
    }
    
    public HeroZCTZ_6(int l){
        super();
        level=l;
        hid=10110;
        id=11110;
        att_born=205;
        def_born=159;
        attGrowth=21.53;
        defGrowth=16.7;
        name="志村团藏";
        star=5;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
