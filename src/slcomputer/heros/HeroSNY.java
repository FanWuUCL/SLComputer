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
public class HeroSNY extends Hero{
    public HeroSNY(){
        this(1);
    }
    
    public HeroSNY(int l){
        super();
        level=l;
        hid=10329;
        id=hid;
        name="少年鼬";
    }
}
