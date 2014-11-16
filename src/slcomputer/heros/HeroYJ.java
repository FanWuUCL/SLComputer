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
public class HeroYJ extends Hero{
    public HeroYJ(){
        this(1);
    }
    
    public HeroYJ(int l){
        super();
        level=l;
        hid=10221;
        id=hid;
        att_born=250;
        def_born=190;
        attGrowth=31.8;
        defGrowth=20.45;
        name="银角";
        star=5;
        style=7;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=10;
    }
}
