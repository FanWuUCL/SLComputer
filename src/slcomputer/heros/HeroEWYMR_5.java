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
public class HeroEWYMR_5 extends HeroEWYMR{
    public HeroEWYMR_5(){
        this(1);
    }
    
    public HeroEWYMR_5(int l){
        super();
        level=l;
        hid=10179;
        id=hid+1000;
        att_born=112;
        def_born=150;
        attGrowth=11.31;
        defGrowth=15.15;
        name="二位由木人";
        star=4;
        style=7;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
