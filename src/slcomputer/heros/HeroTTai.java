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
public class HeroTTai extends Hero{
    public HeroTTai(){
        this(1);
    }
    
    public HeroTTai(int l){
        super();
        level=l;
        hid=10241;
        id=hid;
        name="土台";
    }
}
