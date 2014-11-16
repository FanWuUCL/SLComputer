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
public class HeroYSD extends Hero{
    public HeroYSD(){
        this(1);
    }
    
    public HeroYSD(int l){
        super();
        level=l;
        hid=10131;
        id=hid;
        att_born=128;
        def_born=170;
        attGrowth=12.93;
        defGrowth=17.17;
        name="药师兜";
        star=4;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
