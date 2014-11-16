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
public class HeroZQRZ extends Hero{
    public HeroZQRZ(){
        this(1);
    }
    
    public HeroZQRZ(int l){
        super();
        level=l;
        hid=10281;
        id=hid;
        name="足球忍者";
    }
}
