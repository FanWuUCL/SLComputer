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
public class HeroRXNC extends Hero{
    public HeroRXNC(){
        this(1);
    }
    
    public HeroRXNC(int l){
        super();
        level=l;
        hid=10141;
        id=hid;
        att_born=143;
        def_born=107;
        attGrowth=14.44;
        defGrowth=10.81;
        name="日向宁次";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
