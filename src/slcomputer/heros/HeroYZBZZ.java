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
public class HeroYZBZZ extends Hero{
    public HeroYZBZZ(){
        this(1);
    }
    
    public HeroYZBZZ(int l){
        super();
        level=l;
        hid=10117;
        id=hid;
        att_born=150;
        def_born=113;
        attGrowth=15.15;
        defGrowth=11.41;
        name="宇智波佐助";
        star=4;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
