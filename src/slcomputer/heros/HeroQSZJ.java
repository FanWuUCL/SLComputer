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
public class HeroQSZJ extends Hero{
    public HeroQSZJ(){
        this(1);
    }
    
    public HeroQSZJ(int l){
        super();
        level=l;
        hid=10100;
        id=hid;
        att_born=220;
        def_born=170;
        attGrowth=23.1;
        defGrowth=17.85;
        name="千手柱间";
        star=5;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
