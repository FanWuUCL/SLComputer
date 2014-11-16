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
public class HeroFY extends Hero{
    public HeroFY(){
        this(1);
    }
    
    public HeroFY(int l){
        super();
        level=l;
        hid=10259;
        id=hid;
        name="风鼬";
    }
}
