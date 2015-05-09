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
public class HeroQZZ extends Hero{
    public HeroQZZ(){
        this(1);
    }
    
    public HeroQZZ(int l){
        super();
        level=l;
        hid=10198;
        id=hid;
        att_born=119;
        def_born=89;
        attGrowth=12.02;
        defGrowth=8.99;
        name="犬冢爪";
        star=3;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
