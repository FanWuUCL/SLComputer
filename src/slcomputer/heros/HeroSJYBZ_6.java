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
public class HeroSJYBZ_6 extends HeroSJYBZ{
    public HeroSJYBZ_6(){
        this(1);
    }
    
    public HeroSJYBZ_6(int l){
        super();
        level=l;
        hid=10112;
        id=11112;
        att_born=195;
        def_born=151;
        attGrowth=20.48;
        defGrowth=15.86;
        name="山椒鱼半藏";
        star=5;
        style=4;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
