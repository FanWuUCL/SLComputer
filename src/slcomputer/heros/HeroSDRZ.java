/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import slcomputer.computer.Team;

/**
 *
 * @author J
 */
public class HeroSDRZ extends Hero{
    public HeroSDRZ(){
        this(1);
    }
    
    public HeroSDRZ(int l){
        super();
        level=l;
        hid=10226;
        id=hid;
        att_born=250;
        def_born=190;
        attGrowth=31.8;
        defGrowth=20.45;
        name="圣诞忍者";
        star=5;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=20;
    }
}
