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
public class HeroCT extends Hero{
    public HeroCT(){
        this(1);
    }
    
    public HeroCT(int l){
        super();
        level=l;
        hid=10239;
        id=hid;
        name="赤土";
    }
}
