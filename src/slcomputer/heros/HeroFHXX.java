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
public class HeroFHXX extends Hero{
    public HeroFHXX(){
        this(1);
    }
    
    public HeroFHXX(int l){
        super();
        level=l;
        hid=10230;
        id=hid;
        att_born=220;
        def_born=165;
        attGrowth=23.1;
        defGrowth=17.33;
        name="风花小雪";
        star=5;
        style=9;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
