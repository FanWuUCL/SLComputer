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
public class HeroYM_6 extends HeroYM{
    public HeroYM_6(){
        this(1);
    }
    
    public HeroYM_6(int l){
        super();
        level=l;
        hid=10264;
        id=hid+1000;
        name="猿魔";
    }
}
