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
public class HeroD extends Hero{
    public HeroD(){
        this(1);
    }
    
    public HeroD(int l){
        super();
        level=l;
        hid=10280;
        id=hid;
        name="兜";
    }
}
