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
public class HeroHT extends Hero{
    public HeroHT(){
        this(1);
    }
    
    public HeroHT(int l){
        super();
        level=l;
        hid=10240;
        id=hid;
        name="黑土";
    }
}
