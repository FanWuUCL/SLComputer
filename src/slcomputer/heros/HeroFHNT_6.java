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
public class HeroFHNT_6 extends HeroFHNT{
    public HeroFHNT_6(){
        this(1);
    }
    
    public HeroFHNT_6(int l){
        super();
        level=l;
        hid=10232;
        id=hid+1000;
        att_born=220;
        def_born=165;
        attGrowth=23.1;
        defGrowth=17.33;
        name="风花怒涛";
        star=5;
        style=9;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
