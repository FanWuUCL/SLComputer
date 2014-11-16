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
public class HeroQMKKX extends Hero{
    public HeroQMKKX(){
        this(1);
    }
    
    public HeroQMKKX(int l){
        super();
        level=l;
        hid=10114;
        id=hid;
        att_born=172;
        def_born=129;
        attGrowth=17.37;
        defGrowth=13.03;
        name="旗木卡卡西";
        star=4;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
