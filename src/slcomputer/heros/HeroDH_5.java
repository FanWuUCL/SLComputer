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
public class HeroDH_5 extends HeroDH{
    public HeroDH_5(){
        this(1);
    }
    
    public HeroDH_5(int l){
        super();
        level=l;
        hid=10125;
        id=hid+1000;
        att_born=156;
        def_born=117;
        attGrowth=15.76;
        defGrowth=11.82;
        name="大和";
        star=4;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
