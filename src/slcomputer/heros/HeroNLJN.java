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
public class HeroNLJN extends Hero{
    public HeroNLJN(){
        this(1);
    }
    
    public HeroNLJN(int l){
        super();
        level=l;
        hid=10196;
        id=hid;
        att_born=102;
        def_born=136;
        attGrowth=10.3;
        defGrowth=13.74;
        name="奈良吉乃";
        star=3;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
