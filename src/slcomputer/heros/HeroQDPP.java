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
public class HeroQDPP extends Hero{
    public HeroQDPP(){
        this(1);
    }
    
    public HeroQDPP(int l){
        super();
        level=l;
        hid=10127;
        id=hid;
        att_born=127;
        def_born=169;
        attGrowth=12.83;
        defGrowth=17.07;
        name="千代婆婆";
        star=4;
        style=3;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
