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
public class HeroHL_6 extends HeroHL{
    public HeroHL_6(){
        this(1);
    }
    
    public HeroHL_6(int l){
        super();
        level=l;
        hid=10258;
        id=hid+2000;
        name="红莲";
    }
}
