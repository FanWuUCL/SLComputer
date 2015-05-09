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
public class HeroYFRZ extends Hero{
    public HeroYFRZ(){
        this(1);
    }
    
    public HeroYFRZ(int l){
        super();
        level=l;
        hid=10107;
        id=hid;
        att_born=200;
        def_born=155;
        attGrowth=21;
        defGrowth=16.28;
        name="猿飞日斩";
        star=5;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
