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
public class HeroHYJML extends Hero{
    public HeroHYJML(){
        this(1);
    }
    
    public HeroHYJML(int l){
        super();
        level=l;
        hid=10132;
        id=hid;
        att_born=125;
        def_born=166;
        attGrowth=12.63;
        defGrowth=16.77;
        name="辉夜君麻吕";
        star=4;
        style=5;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
