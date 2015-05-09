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
public class HeroXRZJ_6 extends HeroXRZJ{
    public HeroXRZJ_6(){
        this(1);
    }
    
    public HeroXRZJ_6(int l){
        super();
        level=l;
        hid=10227;
        id=hid+1000;
        att_born=280;
        def_born=210;
        attGrowth=29.4;
        defGrowth=22.05;
        name="仙人柱间";
        star=5;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=11;
    }
}
