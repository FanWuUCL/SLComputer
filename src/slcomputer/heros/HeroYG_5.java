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
public class HeroYG_5 extends HeroYG{
    public HeroYG_5(){
        this(1);
    }
    
    public HeroYG_5(int l){
        super();
        level=l;
        hid=10183;
        id=hid+1000;
        att_born=112;
        def_born=150;
        attGrowth=11.31;
        defGrowth=15.15;
        name="羽高";
        star=4;
        style=1;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
