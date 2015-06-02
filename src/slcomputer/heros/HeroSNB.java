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
public class HeroSNB extends Hero{
    public HeroSNB(){
        this(1);
    }
    
    public HeroSNB(int l){
        super();
        level=l;
        hid=10330;
        id=hid;
        name="少年斑";
    }
}
