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
public class HeroQLB extends Hero{
    public HeroQLB(){
        this(1);
    }
    
    public HeroQLB(int l){
        super();
        level=l;
        hid=10130;
        id=hid;
        att_born=174;
        def_born=131;
        attGrowth=17.57;
        defGrowth=13.23;
        name="奇拉比";
        star=4;
        style=7;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
