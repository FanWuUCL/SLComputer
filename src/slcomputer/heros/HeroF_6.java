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
public class HeroF_6 extends HeroF{
    public HeroF_6(){
        this(1);
    }
    
    public HeroF_6(int l){
        super();
        level=l;
        hid=10182;
        id=hid+2000;
        att_born=113;
        def_born=151;
        attGrowth=11.41;
        defGrowth=15.25;
        name="樊";
        star=4;
        style=2;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
