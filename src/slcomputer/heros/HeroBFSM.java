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
public class HeroBFSM extends Hero{
    public HeroBFSM(){
        this(1);
    }
    
    public HeroBFSM(int l){
        super();
        level=l;
        hid=10102;
        id=hid;
        att_born=206;
        def_born=160;
        attGrowth=21.63;
        defGrowth=16.8;
        name="波风水门";
        star=5;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
