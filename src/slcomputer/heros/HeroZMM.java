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
public class HeroZMM extends Hero{
    public HeroZMM(){
        this(1);
    }
    
    public HeroZMM(int l){
        super();
        level=l;
        hid=10111;
        id=hid;
        att_born=155;
        def_born=200;
        attGrowth=16.28;
        defGrowth=21;
        name="照美冥";
        star=5;
        style=1;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
