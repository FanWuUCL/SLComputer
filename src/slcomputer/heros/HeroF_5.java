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
public class HeroF_5 extends HeroF{
    public HeroF_5(){
        this(1);
    }
    
    public HeroF_5(int l){
        super();
        level=l;
        hid=10182;
        id=hid+1000;
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
