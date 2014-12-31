/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import slcomputer.Hero;

/**
 *
 * @author J
 */
public class HeroSDSY extends Hero{
    public HeroSDSY(){
        this(1);
    }
    
    public HeroSDSY(int l){
        super();
        level=l;
        hid=10308;
        id=hid;
        name="三代水影";
    }
}
