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
public class HeroJMKMR extends Hero{
    public HeroJMKMR(){
        this(1);
    }
    
    public HeroJMKMR(int l){
        super();
        level=l;
        hid=10218;
        id=hid;
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
