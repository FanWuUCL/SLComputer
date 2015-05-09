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
public class HeroHTSM extends Hero{
    public HeroHTSM(){
        this(1);
    }
    
    public HeroHTSM(int l){
        super();
        level=l;
        hid=10287;
        id=hid;
        name="秽土水门";
    }
}
