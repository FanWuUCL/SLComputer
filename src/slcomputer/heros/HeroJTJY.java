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
public class HeroJTJY extends Hero{
    public HeroJTJY(){
        this(1);
    }
    
    public HeroJTJY(int l){
        super();
        level=l;
        hid=10186;
        id=hid;
        att_born=101;
        def_born=135;
        attGrowth=10.2;
        defGrowth=13.64;
        name="加藤静音";
        star=3;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
