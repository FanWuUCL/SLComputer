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
public class HeroSanC extends Hero{
    public HeroSanC(){
        this(1);
    }
    
    public HeroSanC(int l){
        super();
        level=l;
        hid=10228;
        id=hid;
        att_born=280;
        def_born=210;
        attGrowth=29.4;
        defGrowth=22.05;
        name="三船";
        star=5;
        style=2;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=10;
    }
}
