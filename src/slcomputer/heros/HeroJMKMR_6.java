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
public class HeroJMKMR_6 extends HeroJMKMR{
    public HeroJMKMR_6(){
        this(1);
    }
    
    public HeroJMKMR_6(int l){
        super();
        level=l;
        hid=10218;
        id=hid+1000;
        att_born=260;
        def_born=195;
        attGrowth=33.8;
        defGrowth=21.45;
        name="九摩诃鸣人";
        star=5;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=14;
    }
}
