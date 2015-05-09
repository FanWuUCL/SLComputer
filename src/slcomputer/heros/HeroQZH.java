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
public class HeroQZH extends Hero{
    public HeroQZH(){
        this(1);
    }
    
    public HeroQZH(int l){
        super();
        level=l;
        hid=10197;
        id=hid;
        att_born=93;
        def_born=124;
        attGrowth=9.39;
        defGrowth=12.52;
        name="犬冢花";
        star=3;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
