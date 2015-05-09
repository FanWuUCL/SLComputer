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
public class HeroSDFY extends Hero{
    public HeroSDFY(){
        this(1);
    }
    
    public HeroSDFY(int l){
        super();
        level=l;
        hid=10153;
        id=hid;
        att_born=116;
        def_born=154;
        attGrowth=11.72;
        defGrowth=15.55;
        name="四代风影";
        star=4;
        style=3;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
