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
public class HeroRXRC extends Hero{
    public HeroRXRC(){
        this(1);
    }
    
    public HeroRXRC(int l){
        super();
        level=l;
        hid=10194;
        id=hid;
        att_born=116;
        def_born=87;
        attGrowth=11.72;
        defGrowth=8.79;
        name="日向日差";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
