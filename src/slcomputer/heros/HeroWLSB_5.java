/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import slcomputer.Hero;
import slcomputer.Team;

/**
 *
 * @author J
 */
public class HeroWLSB_5 extends HeroWLSB{
    public HeroWLSB_5(){
        this(1);
    }
    
    public HeroWLSB_5(int l){
        super();
        level=l;
        hid=10205;
        id=hid+1000;
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
