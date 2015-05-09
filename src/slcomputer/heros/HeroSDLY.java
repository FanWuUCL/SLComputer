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
public class HeroSDLY extends Hero{
    public HeroSDLY(){
        this(1);
    }
    
    public HeroSDLY(int l){
        super();
        level=l;
        hid=10151;
        id=hid;
        att_born=195;
        def_born=151;
        attGrowth=20.48;
        defGrowth=15.86;
        name="三代雷影";
        star=5;
        style=7;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
