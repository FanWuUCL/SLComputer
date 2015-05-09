/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import slcomputer.computer.Team;

/**
 *
 * @author J
 */
public class HeroHYYLK extends Hero{
    public HeroHYYLK(){
        this(1);
    }
    
    public HeroHYYLK(int l){
        super();
        level=l;
        hid=10144;
        id=hid;
        att_born=100;
        def_born=75;
        attGrowth=10.75;
        defGrowth=8.06;
        name="海野伊鲁卡";
        star=2;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
