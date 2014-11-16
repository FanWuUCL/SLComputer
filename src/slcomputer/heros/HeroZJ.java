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
public class HeroZJ extends Hero{
    public HeroZJ(){
        this(1);
    }
    
    public HeroZJ(int l){
        super();
        level=l;
        hid=10146;
        id=hid;
        att_born=89;
        def_born=118;
        attGrowth=8.99;
        defGrowth=11.92;
        name="佐井";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
