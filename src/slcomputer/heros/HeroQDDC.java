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
public class HeroQDDC extends Hero{
    public HeroQDDC(){
        this(1);
    }
    
    public HeroQDDC(int l){
        super();
        level=l;
        hid=10160;
        id=hid;
        att_born=138;
        def_born=104;
        attGrowth=13.94;
        defGrowth=10.5;
        name="秋道丁次";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
