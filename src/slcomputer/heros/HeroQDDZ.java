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
public class HeroQDDZ extends Hero{
    public HeroQDDZ(){
        this(1);
    }
    
    public HeroQDDZ(int l){
        super();
        level=l;
        hid=10190;
        id=hid;
        att_born=125;
        def_born=94;
        attGrowth=12.63;
        defGrowth=9.49;
        name="秋道丁座";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
