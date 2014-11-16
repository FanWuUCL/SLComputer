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
public class HeroCLF extends Hero{
    public HeroCLF(){
        this(1);
    }
    
    public HeroCLF(int l){
        super();
        level=l;
        hid=10214;
        id=hid;
        att_born=83;
        def_born=110;
        attGrowth=8.38;
        defGrowth=11.11;
        name="次郎坊";
        star=3;
        style=5;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
