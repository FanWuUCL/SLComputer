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
public class HeroRZKJL extends Hero{
    public HeroRZKJL(){
        this(1);
    }
    
    public HeroRZKJL(int l){
        super();
        level=l;
        hid=10253;
        id=hid;
        name="忍战勘九郎";
    }
}
