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
public class HeroZJi extends Hero{
    public HeroZJi(){
        this(1);
    }
    
    public HeroZJi(int l){
        super();
        level=l;
        hid=10275;
        id=hid;
        name="中吉";
    }
}
