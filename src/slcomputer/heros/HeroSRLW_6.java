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
public class HeroSRLW_6 extends HeroSRLW{
    public HeroSRLW_6(){
        this(1);
    }
    
    public HeroSRLW_6(int l){
        super();
        level=l;
        hid=10272;
        id=hid+1000;
        name="上忍鹿丸";
    }
}
