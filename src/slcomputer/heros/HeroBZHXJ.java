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
public class HeroBZHXJ extends Hero{
    public HeroBZHXJ(){
        this(1);
    }
    
    public HeroBZHXJ(int l){
        super();
        level=l;
        hid=10201;
        id=hid;
        att_born=95;
        def_born=130;
        attGrowth=9.6;
        defGrowth=13.13;
        name="不知火玄间";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
