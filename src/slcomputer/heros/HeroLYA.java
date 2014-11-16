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
public class HeroLYA extends Hero{
    public HeroLYA(){
        this(1);
    }
    
    public HeroLYA(int l){
        super();
        level=l;
        hid=10237;
        id=hid;
        name="雷影艾";
    }
}
