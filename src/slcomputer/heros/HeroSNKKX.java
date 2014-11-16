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
public class HeroSNKKX extends Hero{
    public HeroSNKKX(){
        this(1);
    }
    
    public HeroSNKKX(int l){
        super();
        level=l;
        hid=10250;
        id=hid;
        name="少年卡卡西";
    }
}
