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
public class HeroQ extends Hero{
    public HeroQ(){
        this(1);
    }
    
    public HeroQ(int l){
        super();
        level=l;
        hid=10148;
        id=hid;
        att_born=86;
        def_born=115;
        attGrowth=8.69;
        defGrowth=11.62;
        name="青";
        star=3;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
