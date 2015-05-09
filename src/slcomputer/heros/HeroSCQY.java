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
public class HeroSCQY extends Hero{
    public HeroSCQY(){
        this(1);
    }
    
    public HeroSCQY(int l){
        super();
        level=l;
        hid=10199;
        id=hid;
        att_born=102;
        def_born=136;
        attGrowth=10.3;
        defGrowth=13.74;
        name="山城青叶";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
