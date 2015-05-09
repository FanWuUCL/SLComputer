/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import slcomputer.computer.Team;

/**
 *
 * @author J
 */
public class HeroSJY extends Hero{
    public HeroSJY(){
        this(1);
    }
    
    public HeroSJY(int l){
        super();
        level=l;
        hid=10267;
        id=hid;
        name="山椒鱼";
    }
}
