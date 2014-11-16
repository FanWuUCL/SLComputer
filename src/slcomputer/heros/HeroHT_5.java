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
public class HeroHT_5 extends HeroHT{
    public HeroHT_5(){
        this(1);
    }
    
    public HeroHT_5(int l){
        super();
        level=l;
        hid=10240;
        id=hid+1000;
        name="黑土";
    }
}
