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
public class HeroTLY_6 extends HeroTLY{
    public HeroTLY_6(){
        this(1);
    }
    
    public HeroTLY_6(int l){
        super();
        level=l;
        hid=10276;
        id=hid+1000;
        name="特洛伊";
    }
}
