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
public class HeroXY_6 extends HeroXY{
    public HeroXY_6(){
        this(1);
    }
    
    public HeroXY_6(int l){
        super();
        level=l;
        hid=10222;
        id=hid+1000;
        att_born=158;
        def_born=210;
        attGrowth=16.59;
        defGrowth=22.05;
        name="小樱";
        star=5;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}

