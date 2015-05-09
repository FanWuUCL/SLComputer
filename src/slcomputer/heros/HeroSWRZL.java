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
public class HeroSWRZL extends Hero{
    public HeroSWRZL(){
        this(1);
    }
    
    public HeroSWRZL(int l){
        super();
        level=l;
        hid=10217;
        id=hid;
        att_born=260;
        def_born=195;
        attGrowth=33.8;
        defGrowth=21.45;
        name="十尾人柱力";
        star=5;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=11;
    }
}
