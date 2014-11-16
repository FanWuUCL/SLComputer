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
public class HeroXL extends Hero{
    public HeroXL(){
        this(1);
    }
    
    public HeroXL(int l){
        super();
        level=l;
        hid=10145;
        id=hid;
        att_born=117;
        def_born=88;
        attGrowth=11.82;
        defGrowth=8.89;
        name="香磷";
        star=3;
        style=6;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
