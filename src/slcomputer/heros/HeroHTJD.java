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
public class HeroHTJD extends Hero{
    public HeroHTJD(){
        this(1);
    }
    
    public HeroHTJD(int l){
        super();
        level=l;
        hid=10288;
        id=hid;
        name="秽土角都";
    }
}
