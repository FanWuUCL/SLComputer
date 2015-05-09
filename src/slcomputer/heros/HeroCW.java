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
public class HeroCW extends Hero{
    public HeroCW(){
        this(1);
    }
    
    public HeroCW(int l){
        super();
        level=l;
        hid=10168;
        id=hid;
        att_born=107;
        def_born=80;
        attGrowth=11.5;
        defGrowth=8.6;
        name="赤丸";
        star=2;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }    
}
