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
public class HeroQSGS extends Hero{
    public HeroQSGS(){
        this(1);
    }
    
    public HeroQSGS(int l){
        super();
        level=l;
        hid=10106;
        id=hid;
        att_born=154;
        def_born=198;
        attGrowth=16.17;
        defGrowth=20.79;
        name="千手纲手";
        star=5;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
