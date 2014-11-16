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
public class HeroDDL extends Hero{
    public HeroDDL(){
        this(1);
    }
    
    public HeroDDL(int l){
        super();
        level=l;
        hid=10134;
        id=hid;
        att_born=124;
        def_born=165;
        attGrowth=12.52;
        defGrowth=16.67;
        name="迪达拉";
        star=4;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
