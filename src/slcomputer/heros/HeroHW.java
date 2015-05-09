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
public class HeroHW extends Hero{
    public HeroHW(){
        this(1);
    }
    
    public HeroHW(int l){
        super();
        level=l;
        hid=10170;
        id=hid;
        att_born=108;
        def_born=81;
        attGrowth=11.61;
        defGrowth=8.71;
        name="黑丸";
        star=2;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }    
}
