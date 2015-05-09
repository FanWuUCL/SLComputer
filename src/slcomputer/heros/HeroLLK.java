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
public class HeroLLK extends Hero{
    public HeroLLK(){
        this(1);
    }
    
    public HeroLLK(int l){
        super();
        level=l;
        hid=10163;
        id=hid;
        att_born=136;
        def_born=102;
        attGrowth=13.74;
        defGrowth=10.3;
        name="李洛克";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
