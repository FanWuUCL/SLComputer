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
public class HeroEDSY_5 extends HeroEDSY{
    public HeroEDSY_5(){
        this(1);
    }
    
    public HeroEDSY_5(int l){
        super();
        level=l;
        hid=10152;
        id=hid+1000;
        att_born=108;
        def_born=144;
        attGrowth=10.91;
        defGrowth=14.54;
        name="二代水影";
        star=4;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
