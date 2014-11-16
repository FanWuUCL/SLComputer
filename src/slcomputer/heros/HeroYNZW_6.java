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
public class HeroYNZW_6 extends HeroYNZW{
    public HeroYNZW_6(){
        this(1);
    }
    
    public HeroYNZW_6(int l){
        super();
        level=l;
        hid=10191;
        id=hid+2000;
        att_born=155;
        def_born=116;
        attGrowth=15.66;
        defGrowth=11.72;
        name="油女志微";
        star=4;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
