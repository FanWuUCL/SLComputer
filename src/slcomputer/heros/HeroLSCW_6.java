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
public class HeroLSCW_6 extends HeroLSCW{
    public HeroLSCW_6(){
        this(1);
    }
    
    public HeroLSCW_6(int l){
        super();
        level=l;
        hid=10203;
        id=hid+2000;
        att_born=161;
        def_born=121;
        attGrowth=16.26;
        defGrowth=12.22;
        name="栗霰串丸";
        star=4;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
