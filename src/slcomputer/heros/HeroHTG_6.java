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
public class HeroHTG_6 extends HeroHTG{
    public HeroHTG_6(){
        this(1);
    }
    
    public HeroHTG_6(int l){
        super();
        level=l;
        hid=10206;
        id=hid+2000;
        att_born=156;
        def_born=117;
        attGrowth=15.76;
        defGrowth=11.82;
        name="河豚鬼";
        star=4;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
