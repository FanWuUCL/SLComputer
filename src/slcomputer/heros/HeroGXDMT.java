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
public class HeroGXDMT extends Hero{
    public HeroGXDMT(){
        this(1);
    }
    
    public HeroGXDMT(int l){
        super();
        level=l;
        hid=10209;
        id=hid;
        att_born=72;
        def_born=96;
        attGrowth=7.74;
        defGrowth=10.32;
        name="鬼兄弟冥头";
        star=2;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
