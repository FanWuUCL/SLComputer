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
public class HeroHBS extends Hero{
    public HeroHBS(){
        this(1);
    }
    
    public HeroHBS(int l){
        super();
        level=l;
        hid=10208;
        id=hid;
        att_born=113;
        def_born=85;
        attGrowth=11.41;
        defGrowth=8.59;
        name="惠比寿";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
