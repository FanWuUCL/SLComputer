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
public class HeroSDFY_5 extends HeroSDFY{
    public HeroSDFY_5(){
        this(1);
    }
    
    public HeroSDFY_5(int l){
        super();
        level=l;
        hid=10153;
        id=hid+1000;
        att_born=116;
        def_born=154;
        attGrowth=11.72;
        defGrowth=15.55;
        name="四代风影";
        star=4;
        style=3;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
