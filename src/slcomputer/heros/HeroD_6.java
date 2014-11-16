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
public class HeroD_6 extends HeroD{
    public HeroD_6(){
        this(1);
    }
    
    public HeroD_6(int l){
        super();
        level=l;
        hid=10280;
        id=hid+1000;
        name="兜";
    }
}
