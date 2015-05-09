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
public class HeroZLY extends Hero{
    public HeroZLY(){
        this(1);
    }
    
    public HeroZLY(int l){
        super();
        level=l;
        hid=10103;
        id=hid;
        att_born=162;
        def_born=210;
        attGrowth=17.01;
        defGrowth=22.05;
        name="自来也";
        star=5;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
