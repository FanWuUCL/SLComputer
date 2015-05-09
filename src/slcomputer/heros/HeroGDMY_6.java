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
public class HeroGDMY_6 extends HeroGDMY{
    public HeroGDMY_6(){
        this(1);
    }
    
    public HeroGDMY_6(int l){
        super();
        level=l;
        hid=10204;
        id=hid+2000;
        att_born=164;
        def_born=123;
        attGrowth=16.56;
        defGrowth=12.42;
        name="鬼灯满月";
        star=4;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
