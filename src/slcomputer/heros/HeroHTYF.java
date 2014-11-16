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
public class HeroHTYF extends Hero{
    public HeroHTYF(){
        this(1);
    }
    
    public HeroHTYF(int l){
        super();
        level=l;
        hid=10286;
        id=hid;
        name="秽土猿飞";
    }
}
