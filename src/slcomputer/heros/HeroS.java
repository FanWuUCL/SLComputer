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
public class HeroS extends Hero{
    public HeroS(){
        this(1);
    }
    
    public HeroS(int l){
        super();
        level=l;
        hid=10277;
        id=hid;
        name="狩";
    }
}
