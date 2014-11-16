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
public class HeroYZBFY extends Hero{
    public HeroYZBFY(){
        this(1);
    }
    
    public HeroYZBFY(int l){
        super();
        level=l;
        hid=10192;
        id=hid;
        att_born=138;
        def_born=104;
        attGrowth=13.94;
        defGrowth=10.5;
        name="宇智波富岳";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
