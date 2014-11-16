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
public class HeroHL extends Hero{
    public HeroHL(){
        this(1);
    }
    
    public HeroHL(int l){
        super();
        level=l;
        hid=10258;
        id=hid;
        name="红莲";
    }
}
