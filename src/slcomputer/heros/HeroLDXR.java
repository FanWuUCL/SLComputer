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
public class HeroLDXR extends Hero{
    public HeroLDXR(){
        this(1);
    }
    
    public HeroLDXR(int l){
        super();
        level=l;
        hid=10317;
        id=hid;
        name="六道仙人";
    }
}
