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
public class HeroQZY extends Hero{
    public HeroQZY(){
        this(1);
    }
    
    public HeroQZY(int l){
        super();
        level=l;
        hid=10161;
        id=hid;
        att_born=117;
        def_born=88;
        attGrowth=11.82;
        defGrowth=8.89;
        name="犬冢牙";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
