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
public class HeroXN_5 extends HeroXN{
    public HeroXN_5(){
        this(1);
    }
    
    public HeroXN_5(int l){
        super();
        level=l;
        hid=10122;
        id=hid+1000;
        att_born=120;
        def_born=160;
        attGrowth=12.12;
        defGrowth=16.16;
        name="小南";
        star=4;
        style=6;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
