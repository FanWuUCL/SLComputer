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
public class HeroDSD_6 extends HeroDSD{
    public HeroDSD_6(){
        this(1);
    }
    
    public HeroDSD_6(int l){
        super();
        level=l;
        hid=10215;
        id=hid+1000;
        att_born=195;
        def_born=260;
        attGrowth=21.45;
        defGrowth=33.8;
        name="大蛇兜";
        star=5;
        style=5;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=12;
    }
}
