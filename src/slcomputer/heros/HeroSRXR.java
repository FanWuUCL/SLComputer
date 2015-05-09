/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import slcomputer.computer.Team;

/**
 *
 * @author J
 */
public class HeroSRXR extends Hero{
    public HeroSRXR(){
        this(1);
    }
    
    public HeroSRXR(int l){
        super();
        level=l;
        hid=10173;
        id=hid;
        att_born=65;
        def_born=49;
        attGrowth=6.7;
        defGrowth=5.05;
        name="砂忍下忍";
        star=1;
        style=3;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
