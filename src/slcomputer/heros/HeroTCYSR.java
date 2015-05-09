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
public class HeroTCYSR extends Hero{
    public HeroTCYSR(){
        this(1);
    }
    
    public HeroTCYSR(int l){
        super();
        level=l;
        hid=10207;
        id=hid;
        att_born=162;
        def_born=122;
        attGrowth=16.36;
        defGrowth=12.32;
        name="通草野饵人";
        star=4;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
