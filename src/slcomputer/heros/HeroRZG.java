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
public class HeroRZG extends Hero{
    public HeroRZG(){
        this(1);
    }
    
    public HeroRZG(int l){
        super();
        level=l;
        hid=10270;
        id=hid;
        name="忍者龟";
    }
}
