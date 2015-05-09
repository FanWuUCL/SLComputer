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
public class HeroBSFD extends Hero{
    public HeroBSFD(){
        this(1);
    }
    
    public HeroBSFD(int l){
        super();
        level=l;
        hid=10293;
        id=hid;
        name="不死飞段";
    }
}
