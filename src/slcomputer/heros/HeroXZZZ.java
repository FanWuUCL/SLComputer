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
public class HeroXZZZ extends Hero{
    public HeroXZZZ(){
        this(1);
    }
    
    public HeroXZZZ(int l){
        super();
        level=l;
        hid=10219;
        id=hid;
        att_born=260;
        def_born=195;
        attGrowth=33.8;
        defGrowth=21.45;
        name="须佐佐助";
        star=5;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=13;
    }
}
