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
public class HeroAXL extends Hero{
    public HeroAXL(){
        this(1);
    }
    
    public HeroAXL(int l){
        super();
        level=l;
        hid=10319;
        id=hid;
        name="阿修罗";
    }
}
