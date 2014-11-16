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
public class HeroHYCX extends Hero{
    public HeroHYCX(){
        this(1);
    }
    
    public HeroHYCX(int l){
        super();
        level=l;
        hid=10234;
        id=hid;
        att_born=169;
        def_born=127;
        attGrowth=17.07;
        defGrowth=12.83;
        name="鹤翼吹雪";
        star=4;
        style=9;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
