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
public class HeroYZBMQ extends Hero{
    public HeroYZBMQ(){
        this(1);
    }
    
    public HeroYZBMQ(int l){
        super();
        level=l;
        hid=10193;
        id=hid;
        att_born=124;
        def_born=93;
        attGrowth=12.52;
        defGrowth=9.39;
        name="宇智波美琴";
        star=3;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
