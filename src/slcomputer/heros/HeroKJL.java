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
public class HeroKJL extends Hero{
    public HeroKJL(){
        this(1);
    }
    
    public HeroKJL(int l){
        super();
        level=l;
        hid=10147;
        id=hid;
        att_born=83;
        def_born=110;
        attGrowth=8.38;
        defGrowth=11.11;
        name="勘九郎";
        star=3;
        style=3;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
