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
public class HeroYM extends Hero{
    public HeroYM(){
        this(1);
    }
    
    public HeroYM(int l){
        super();
        level=l;
        hid=10264;
        id=hid;
        name="猿魔";
    }
}
