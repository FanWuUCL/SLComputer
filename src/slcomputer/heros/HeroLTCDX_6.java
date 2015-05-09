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
public class HeroLTCDX_6 extends HeroLTCDX{
    public HeroLTCDX_6(){
        this(1);
    }
    
    public HeroLTCDX_6(int l){
        super();
        level=l;
        hid=10159;
        id=hid+2000;
        att_born=111;
        def_born=148;
        attGrowth=11.21;
        defGrowth=14.95;
        name="两天秤大轩";
        star=4;
        style=2;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
