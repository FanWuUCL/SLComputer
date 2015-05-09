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
public class HeroW extends Hero{
    public HeroW(){
        this(1);
    }
    
    public HeroW(int l){
        super();
        level=l;
        hid=10138;
        id=hid;
        att_born=125;
        def_born=166;
        attGrowth=12.63;
        defGrowth=16.77;
        name="无";
        star=4;
        style=2;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
