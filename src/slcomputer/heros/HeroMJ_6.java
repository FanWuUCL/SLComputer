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
public class HeroMJ_6 extends HeroMJ{
    public HeroMJ_6(){
        this(1);
    }
    
    public HeroMJ_6(int l){
        super();
        level=l;
        hid=10126;
        id=hid+2000;
        att_born=125;
        def_born=166;
        attGrowth=12.63;
        defGrowth=16.77;
        name="马基";
        star=4;
        style=3;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
