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
public class HeroFHXX_6 extends HeroFHXX{
    public HeroFHXX_6(){
        this(1);
    }
    
    public HeroFHXX_6(int l){
        super();
        level=l;
        hid=10230;
        id=hid+1000;
        att_born=220;
        def_born=165;
        attGrowth=23.1;
        defGrowth=17.33;
        name="风花小雪";
        star=5;
        style=9;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
