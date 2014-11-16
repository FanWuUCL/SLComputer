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
public class HeroGDSY extends Hero{
    public HeroGDSY(){
        this(1);
    }
    
    public HeroGDSY(int l){
        super();
        level=l;
        hid=10121;
        id=hid;
        att_born=129;
        def_born=97;
        attGrowth=13.03;
        defGrowth=9.8;
        name="鬼灯水月";
        star=3;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
