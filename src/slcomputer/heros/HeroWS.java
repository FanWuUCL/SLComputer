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
public class HeroWS extends Hero{
    public HeroWS(){
        this(1);
    }
    
    public HeroWS(int l){
        super();
        level=l;
        hid=10260;
        id=hid;
        name="万蛇";
    }
}
