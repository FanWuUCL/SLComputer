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
public class HeroHT_6 extends HeroHT{
    public HeroHT_6(){
        this(1);
    }
    
    public HeroHT_6(int l){
        super();
        level=l;
        hid=10240;
        id=hid+2000;
        name="黑土";
    }
}
