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
public class HeroXRZLY extends Hero{
    public HeroXRZLY(){
        this(1);
    }
    
    public HeroXRZLY(int l){
        super();
        level=l;
        hid=10245;
        id=hid;
        name="仙人自来也";
    }
}
