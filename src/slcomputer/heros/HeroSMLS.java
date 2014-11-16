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
public class HeroSMLS extends Hero{
    public HeroSMLS(){
        this(1);
    }
    
    public HeroSMLS(int l){
        super();
        level=l;
        hid=10185;
        id=hid;
        att_born=78;
        def_born=104;
        attGrowth=8.39;
        defGrowth=11.18;
        name="水木老师";
        star=2;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
