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
public class HeroGTW extends Hero{
    public HeroGTW(){
        this(1);
    }
    
    public HeroGTW(int l){
        super();
        level=l;
        hid=10211;
        id=hid;
        att_born=80;
        def_born=107;
        attGrowth=8.08;
        defGrowth=10.81;
        name="鬼童丸";
        star=3;
        style=5;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
