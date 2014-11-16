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
public class HeroZQXC extends Hero{
    public HeroZQXC(){
        this(1);
    }
    
    public HeroZQXC(int l){
        super();
        level=l;
        hid=10156;
        id=hid;
        att_born=111;
        def_born=84;
        attGrowth=11.21;
        defGrowth=8.48;
        name="转寝小春";
        star=3;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
