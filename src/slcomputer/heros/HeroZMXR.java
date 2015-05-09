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
public class HeroZMXR extends Hero{
    public HeroZMXR(){
        this(1);
    }
    
    public HeroZMXR(int l){
        super();
        level=l;
        hid=10269;
        id=hid;
        name="志麻仙人";
    }
}
