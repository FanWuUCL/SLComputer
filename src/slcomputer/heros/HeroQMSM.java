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
public class HeroQMSM extends Hero{
    public HeroQMSM(){
        this(1);
    }
    
    public HeroQMSM(int l){
        super();
        level=l;
        hid=10187;
        id=hid;
        att_born=174;
        def_born=131;
        attGrowth=17.57;
        defGrowth=13.23;
        name="旗木朔茂";
        star=4;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
