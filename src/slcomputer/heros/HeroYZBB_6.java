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
public class HeroYZBB_6 extends HeroYZBB{
    public HeroYZBB_6(){
        this(1);
    }
    
    public HeroYZBB_6(int l){
        super();
        level=l;
        hid=10113;
        id=hid+1000;
        att_born=220;
        def_born=170;
        attGrowth=23.1;
        defGrowth=17.85;
        name="宇智波斑";
        star=5;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
