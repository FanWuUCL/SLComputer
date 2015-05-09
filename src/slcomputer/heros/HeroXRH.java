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
public class HeroXRH extends Hero{
    public HeroXRH(){
        this(1);
    }
    
    public HeroXRH(int l){
        super();
        level=l;
        hid=10139;
        id=hid;
        att_born=136;
        def_born=102;
        attGrowth=13.74;
        defGrowth=10.3;
        name="夕日红";
        star=3;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
