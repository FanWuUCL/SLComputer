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
public class HeroJWSM_6 extends HeroJWSM{
    public HeroJWSM_6(){
        this(1);
    }
    
    public HeroJWSM_6(int l){
        super();
        level=l;
        hid=10229;
        id=hid+1000;
        att_born=280;
        def_born=210;
        attGrowth=29.4;
        defGrowth=22.05;
        name="九尾水门";
        star=5;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=14;
    }
}
