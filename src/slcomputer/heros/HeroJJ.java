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
public class HeroJJ extends Hero{
    public HeroJJ(){
        this(1);
    }
    
    public HeroJJ(int l){
        super();
        level=l;
        hid=10220;
        id=hid;
        att_born=260;
        def_born=195;
        attGrowth=33.8;
        defGrowth=21.45;
        name="金角";
        star=5;
        style=7;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=10;
    }
}
