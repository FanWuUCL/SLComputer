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
public class HeroWRXR extends Hero{
    public HeroWRXR(){
        this(1);
    }
    
    public HeroWRXR(int l){
        super();
        level=l;
        hid=10174;
        id=hid;
        att_born=52;
        def_born=70;
        attGrowth=5.36;
        defGrowth=7.21;
        name="雾忍下忍";
        star=1;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
