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
public class HeroYZBDT extends Hero{
    public HeroYZBDT(){
        this(1);
    }
    
    public HeroYZBDT(int l){
        super();
        level=l;
        hid=10108;
        id=hid;
        att_born=161;
        def_born=208;
        attGrowth=16.91;
        defGrowth=21.84;
        name="宇智波带土";
        star=5;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
