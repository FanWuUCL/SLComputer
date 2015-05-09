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
public class HeroZSY extends Hero{
    public HeroZSY(){
        this(1);
    }
    
    public HeroZSY(int l){
        super();
        level=l;
        hid=10244;
        id=hid;
        name="转生鼬";
    }
}
