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
public class HeroDDL_5 extends HeroDDL{
    public HeroDDL_5(){
        this(1);
    }
    
    public HeroDDL_5(int l){
        super();
        level=l;
        hid=10134;
        id=hid+1000;
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
