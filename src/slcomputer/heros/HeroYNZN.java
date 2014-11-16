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
public class HeroYNZN extends Hero{
    public HeroYNZN(){
        this(1);
    }
    
    public HeroYNZN(int l){
        super();
        level=l;
        hid=10164;
        id=hid;
        att_born=139;
        def_born=104;
        attGrowth=14.04;
        defGrowth=10.5;
        name="油女志乃";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
