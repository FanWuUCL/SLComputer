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
public class HeroTDZBZ_6 extends HeroTDZBZ{
    public HeroTDZBZ_6(){
        this(1);
    }
    
    public HeroTDZBZ_6(int l){
        super();
        level=l;
        hid=10119;
        id=hid+2000;
        att_born=152;
        def_born=114;
        attGrowth=15.35;
        defGrowth=11.51;
        name="桃地再不斩";
        star=4;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
