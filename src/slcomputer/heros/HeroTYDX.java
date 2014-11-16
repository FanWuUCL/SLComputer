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
public class HeroTYDX extends Hero{
    public HeroTYDX(){
        this(1);
    }
    
    public HeroTYDX(int l){
        super();
        level=l;
        hid=10238;
        id=hid;
        name="土影大轩";
    }
}
