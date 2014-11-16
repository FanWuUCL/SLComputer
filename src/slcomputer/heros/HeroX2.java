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
public class HeroX2 extends Hero{
    public HeroX2(){
        this(1);
    }
    
    public HeroX2(int l){
        super();
        level=l;
        hid=10178;
        id=hid;
        att_born=87;
        def_born=116;
        attGrowth=8.79;
        defGrowth=11.72;
        name="信";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
