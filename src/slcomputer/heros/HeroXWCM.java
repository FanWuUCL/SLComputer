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
public class HeroXWCM extends Hero{
    public HeroXWCM(){
        this(1);
    }
    
    public HeroXWCM(int l){
        super();
        level=l;
        hid=10109;
        id=hid;
        att_born=170;
        def_born=220;
        attGrowth=17.85;
        defGrowth=23.1;
        name="漩涡长门";
        star=5;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
