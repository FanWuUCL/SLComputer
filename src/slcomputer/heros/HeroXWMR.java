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
public class HeroXWMR extends Hero{
    public HeroXWMR(){
        this(1);
    }
    
    public HeroXWMR(int l){
        super();
        level=l;
        hid=10142;
        id=hid;
        att_born=150;
        def_born=113;
        attGrowth=15.15;
        defGrowth=11.41;
        name="漩涡鸣人";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
