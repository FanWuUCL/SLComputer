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
public class HeroZCTZ extends Hero{
    public HeroZCTZ(){
        this(1);
    }
    
    public HeroZCTZ(int l){
        super();
        level=l;
        hid=10110;
        id=hid;
        att_born=205;
        def_born=159;
        attGrowth=21.53;
        defGrowth=16.7;
        name="志村团藏";
        star=5;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
