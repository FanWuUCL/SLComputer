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
public class HeroHL_5 extends HeroHL{
    public HeroHL_5(){
        this(1);
    }
    
    public HeroHL_5(int l){
        super();
        level=l;
        hid=10258;
        id=hid+1000;
        name="红莲";
    }
}
