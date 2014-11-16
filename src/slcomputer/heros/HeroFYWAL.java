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
public class HeroFYWAL extends Hero{
    public HeroFYWAL(){
        this(1);
    }
    
    public HeroFYWAL(int l){
        super();
        level=l;
        hid=10223;
        id=hid;
        att_born=158;
        def_born=210;
        attGrowth=16.59;
        defGrowth=22.05;
        name="风影我爱罗";
        star=5;
        style=3;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
