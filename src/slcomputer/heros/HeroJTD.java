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
public class HeroJTD extends Hero{
    public HeroJTD(){
        this(1);
    }
    
    public HeroJTD(int l){
        super();
        level=l;
        hid=10195;
        id=hid;
        att_born=103;
        def_born=137;
        attGrowth=10.4;
        defGrowth=13.84;
        name="加藤断";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
