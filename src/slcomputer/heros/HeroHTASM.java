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
public class HeroHTASM extends Hero{
    public HeroHTASM(){
        this(1);
    }
    
    public HeroHTASM(int l){
        super();
        level=l;
        hid=10290;
        id=hid;
        name="秽土阿斯玛";
    }
}
