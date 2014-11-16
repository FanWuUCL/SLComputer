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
public class HeroYYL extends Hero{
    public HeroYYL(){
        this(1);
    }
    
    public HeroYYL(int l){
        super();
        level=l;
        hid=10154;
        id=hid;
        att_born=121;
        def_born=91;
        attGrowth=12.22;
        defGrowth=9.19;
        name="野原琳";
        star=3;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
