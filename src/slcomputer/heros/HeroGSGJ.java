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
public class HeroGSGJ extends Hero{
    public HeroGSGJ(){
        this(1);
    }
    
    public HeroGSGJ(int l){
        super();
        level=l;
        hid=10116;
        id=hid;
        att_born=168;
        def_born=126;
        attGrowth=16.97;
        defGrowth=12.73;
        name="干柿鬼鲛";
        star=4;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
