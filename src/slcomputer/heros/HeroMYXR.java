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
public class HeroMYXR extends Hero{
    public HeroMYXR(){
        this(1);
    }
    
    public HeroMYXR(int l){
        super();
        level=l;
        hid=10171;
        id=hid;
        att_born=90;
        def_born=68;
        attGrowth=9.27;
        defGrowth=7;
        name="木叶下忍";
        star=1;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
