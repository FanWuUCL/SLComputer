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
public class HeroSZXR extends Hero{
    public HeroSZXR(){
        this(1);
    }
    
    public HeroSZXR(int l){
        super();
        level=l;
        hid=10268;
        id=hid;
        name="深作仙人";
    }
}
