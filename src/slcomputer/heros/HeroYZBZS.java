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
public class HeroYZBZS extends Hero{
    public HeroYZBZS(){
        this(1);
    }
    
    public HeroYZBZS(int l){
        super();
        level=l;
        hid=10246;
        id=hid;
        name="宇智波止水";
    }
}
