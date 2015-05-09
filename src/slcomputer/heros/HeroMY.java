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
public class HeroMY extends Hero{
    public HeroMY(){
        this(1);
    }
    
    public HeroMY(int l){
        super();
        level=l;
        hid=10169;
        id=hid;
        att_born=92;
        def_born=69;
        attGrowth=9.89;
        defGrowth=7.42;
        name="弥彦";
        star=2;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
