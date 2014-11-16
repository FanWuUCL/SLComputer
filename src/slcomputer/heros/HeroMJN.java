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
public class HeroMJN extends Hero{
    public HeroMJN(){
        this(1);
    }
    
    public HeroMJN(int l){
        super();
        level=l;
        hid=10216;
        id=hid;
        att_born=195;
        def_born=260;
        attGrowth=21.45;
        defGrowth=33.8;
        name="面具男";
        star=5;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=10;
    }
}
