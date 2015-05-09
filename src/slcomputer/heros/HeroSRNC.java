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
public class HeroSRNC extends Hero{
    public HeroSRNC(){
        this(1);
    }
    
    public HeroSRNC(int l){
        super();
        level=l;
        hid=10273;
        id=hid;
        name="上忍宁次";
    }
}
