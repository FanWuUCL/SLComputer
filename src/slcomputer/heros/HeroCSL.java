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
public class HeroCSL extends Hero{
    public HeroCSL(){
        this(1);
    }
    
    public HeroCSL(int l){
        super();
        level=l;
        hid=10128;
        id=hid;
        att_born=110;
        def_born=147;
        attGrowth=11.11;
        defGrowth=14.85;
        name="长十郎";
        star=4;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
