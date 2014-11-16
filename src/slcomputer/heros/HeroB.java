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
public class HeroB extends Hero{
    public HeroB(){
        this(1);
    }
    
    public HeroB(int l){
        super();
        level=l;
        hid=10166;
        id=hid;
        att_born=118;
        def_born=89;
        attGrowth=11.92;
        defGrowth=8.99;
        name="白";
        star=3;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
