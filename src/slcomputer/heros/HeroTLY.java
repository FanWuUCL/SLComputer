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
public class HeroTLY extends Hero{
    public HeroTLY(){
        this(1);
    }
    
    public HeroTLY(int l){
        super();
        level=l;
        hid=10276;
        id=hid;
        name="特洛伊";
    }
}
