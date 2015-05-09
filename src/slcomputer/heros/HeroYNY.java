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
public class HeroYNY extends Hero{
    public HeroYNY(){
        this(1);
    }
    
    public HeroYNY(int l){
        super();
        level=l;
        hid=10176;
        id=hid;
        att_born=100;
        def_born=133;
        attGrowth=10.1;
        defGrowth=13.43;
        name="野乃宇";
        star=3;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
