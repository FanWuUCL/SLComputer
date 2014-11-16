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
public class HeroZJYJ extends Hero{
    public HeroZJYJ(){
        this(1);
    }
    
    public HeroZJYJ(int l){
        super();
        level=l;
        hid=10212;
        id=hid;
        att_born=94;
        def_born=125;
        attGrowth=9.49;
        defGrowth=12.63;
        name="左近右近";
        star=3;
        style=5;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
