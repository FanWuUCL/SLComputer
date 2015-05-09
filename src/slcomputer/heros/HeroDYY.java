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
public class HeroDYY extends Hero{
    public HeroDYY(){
        this(1);
    }
    
    public HeroDYY(int l){
        super();
        level=l;
        hid=10213;
        id=hid;
        att_born=95;
        def_born=127;
        attGrowth=9.6;
        defGrowth=12.83;
        name="多由也";
        star=3;
        style=5;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
