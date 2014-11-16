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
public class HeroYSXHD extends Hero{
    public HeroYSXHD(){
        this(1);
    }
    
    public HeroYSXHD(int l){
        super();
        level=l;
        hid=10150;
        id=hid;
        att_born=82;
        def_born=109;
        attGrowth=8.28;
        defGrowth=11.01;
        name="御手洗红豆";
        star=3;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
