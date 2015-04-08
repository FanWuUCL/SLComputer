/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import slcomputer.Hero;

/**
 *
 * @author J
 */
public class HeroMYZZ extends Hero{
    public HeroMYZZ(){
        this(1);
    }
    
    public HeroMYZZ(int l){
        super();
        level=l;
        hid=10325;
        id=hid;
        name="木叶佐助";
    }
}
