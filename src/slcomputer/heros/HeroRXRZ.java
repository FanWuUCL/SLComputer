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
public class HeroRXRZ extends Hero{
    public HeroRXRZ(){
        this(1);
    }
    
    public HeroRXRZ(int l){
        super();
        level=l;
        hid=10177;
        id=hid;
        att_born=136;
        def_born=102;
        attGrowth=13.74;
        defGrowth=10.3;
        name="日向日足";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
