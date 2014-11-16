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
public class HeroABGJ_6 extends HeroABGJ{
    public HeroABGJ_6(){
        this(1);
    }
    
    public HeroABGJ_6(int l){
        super();
        level=l;
        hid=10224;
        id=hid+1000;
        att_born=210;
        def_born=158;
        attGrowth=22.05;
        defGrowth=16.59;
        name="暗部鬼鲛";
        star=5;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
