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
public class HeroWLSB_6 extends HeroWLSB{
    public HeroWLSB_6(){
        this(1);
    }
    
    public HeroWLSB_6(int l){
        super();
        level=l;
        hid=10205;
        id=hid+2000;
        att_born=165;
        def_born=124;
        attGrowth=16.67;
        defGrowth=12.52;
        name="无梨甚八";
        star=4;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
