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
public class HeroSZJY extends Hero{
    public HeroSZJY(){
        this(1);
    }
    
    public HeroSZJY(int l){
        super();
        level=l;
        hid=10165;
        id=hid;
        att_born=105;
        def_born=79;
        attGrowth=11.29;
        defGrowth=8.49;
        name="山中井野";
        star=2;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
