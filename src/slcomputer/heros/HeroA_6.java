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
public class HeroA_6 extends HeroA{
    public HeroA_6(){
        this(1);
    }
    
    public HeroA_6(int l){
        super();
        level=l;
        hid=10129;
        id=hid+2000;
        att_born=163;
        def_born=122;
        attGrowth=16.46;
        defGrowth=12.32;
        name="艾";
        star=4;
        style=7;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
