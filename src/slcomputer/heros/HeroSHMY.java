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
public class HeroSHMY extends Hero{
    public HeroSHMY(){
        this(1);
    }
    
    public HeroSHMY(int l){
        super();
        level=l;
        hid=10155;
        id=hid;
        att_born=109;
        def_born=82;
        attGrowth=11.01;
        defGrowth=8.28;
        name="水户门炎";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
