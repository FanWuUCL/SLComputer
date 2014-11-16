/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import slcomputer.Hero;
import slcomputer.Team;

/**
 *
 * @author J
 */
public class HeroQLB_5 extends HeroQLB{
    public HeroQLB_5(){
        this(1);
    }
    
    public HeroQLB_5(int l){
        super();
        level=l;
        hid=10130;
        id=hid+1000;
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
