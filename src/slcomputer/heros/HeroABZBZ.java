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
public class HeroABZBZ extends Hero{
    public HeroABZBZ(){
        this(1);
    }
    
    public HeroABZBZ(int l){
        super();
        level=l;
        hid=10225;
        id=hid;
        att_born=210;
        def_born=158;
        attGrowth=22.05;
        defGrowth=16.59;
        name="暗部再不斩";
        star=5;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
