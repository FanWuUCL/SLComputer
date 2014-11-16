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
public class HeroYRXR extends Hero{
    public HeroYRXR(){
        this(1);
    }
    
    public HeroYRXR(int l){
        super();
        level=l;
        hid=10172;
        id=hid;
        att_born=60;
        def_born=80;
        attGrowth=6.18;
        defGrowth=8.24;
        name="岩忍下忍";
        star=1;
        style=2;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
