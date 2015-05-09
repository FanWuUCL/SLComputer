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
public class HeroFD_6 extends HeroFD{
    public HeroFD_6(){
        this(1);
    }
    
    public HeroFD_6(int l){
        super();
        level=l;
        hid=10135;
        id=hid+2000;
        att_born=120;
        def_born=160;
        attGrowth=12.12;
        defGrowth=16.16;
        name="飞段";
        star=4;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
