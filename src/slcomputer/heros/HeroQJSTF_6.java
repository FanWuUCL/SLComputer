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
public class HeroQJSTF_6 extends HeroQJSTF{
    public HeroQJSTF_6(){
        this(1);
    }
    
    public HeroQJSTF_6(int l){
        super();
        level=l;
        hid=10231;
        id=hid+2000;
        att_born=160;
        def_born=120;
        attGrowth=16.16;
        defGrowth=12.12;
        name="浅间三太夫";
        star=4;
        style=9;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
