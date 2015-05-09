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
public class HeroWAL extends Hero{
    public HeroWAL(){
        this(1);
    }
    
    public HeroWAL(int l){
        super();
        level=l;
        hid=10140;
        id=hid;
        att_born=113;
        def_born=150;
        attGrowth=11.41;
        defGrowth=15.15;
        name="我爱罗";
        star=3;
        style=3;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
