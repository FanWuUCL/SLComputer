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
public class HeroXWBR extends Hero{
    public HeroXWBR(){
        this(1);
    }
    
    public HeroXWBR(int l){
        super();
        level=l;
        hid=10324;
        id=hid;
        name="漩涡博人";
    }
}
