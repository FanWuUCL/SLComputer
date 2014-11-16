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
public class HeroLTCDX extends Hero{
    public HeroLTCDX(){
        this(1);
    }
    
    public HeroLTCDX(int l){
        super();
        level=l;
        hid=10159;
        id=hid;
        att_born=111;
        def_born=148;
        attGrowth=11.21;
        defGrowth=14.95;
        name="两天秤大轩";
        star=4;
        style=2;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
