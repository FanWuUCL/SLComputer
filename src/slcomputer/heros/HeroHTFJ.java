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
public class HeroHTFJ extends Hero{
    public HeroHTFJ(){
        this(1);
    }
    
    public HeroHTFJ(int l){
        super();
        level=l;
        hid=10285;
        id=hid;
        name="秽土扉间";
    }
}
