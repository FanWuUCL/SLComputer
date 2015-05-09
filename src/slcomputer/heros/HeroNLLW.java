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
public class HeroNLLW extends Hero{
    public HeroNLLW(){
        this(1);
    }
    
    public HeroNLLW(int l){
        super();
        level=l;
        hid=10158;
        id=hid;
        att_born=105;
        def_born=140;
        attGrowth=10.61;
        defGrowth=14.14;
        name="奈良鹿丸";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
