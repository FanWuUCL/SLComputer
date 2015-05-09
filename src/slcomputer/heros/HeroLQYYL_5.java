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
public class HeroLQYYL_5 extends HeroLQYYL{
    public HeroLQYYL_5(){
        this(1);
    }
    
    public HeroLQYYL_5(int l){
        super();
        level=l;
        hid=10202;
        id=hid+1000;
        att_born=156;
        def_born=117;
        attGrowth=15.76;
        defGrowth=11.82;
        name="林檎雨由利";
        star=4;
        style=1;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
