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
public class HeroYTL extends Hero{
    public HeroYTL(){
        this(1);
    }
    
    public HeroYTL(int l){
        super();
        level=l;
        hid=10320;
        id=hid;
        name="因陀罗";
    }
}
