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
public class HeroLHCM extends Hero{
    public HeroLHCM(){
        this(1);
    }
    
    public HeroLHCM(int l){
        super();
        level=l;
        hid=10283;
        id=hid;
        name="轮回长门";
    }
}
