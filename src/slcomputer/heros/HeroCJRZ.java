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
public class HeroCJRZ extends Hero{
    public HeroCJRZ(){
        this(1);
    }
    
    public HeroCJRZ(int l){
        super();
        level=l;
        hid=10323;
        id=hid;
        name="春节忍者";
    }
}
