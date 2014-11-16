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
public class HeroTTai_5 extends HeroTTai{
    public HeroTTai_5(){
        this(1);
    }
    
    public HeroTTai_5(int l){
        super();
        level=l;
        hid=10241;
        id=hid+1000;
        name="土台";
    }
}
