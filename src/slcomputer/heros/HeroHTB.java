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
public class HeroHTB extends Hero{
    public HeroHTB(){
        this(1);
    }
    
    public HeroHTB(int l){
        super();
        level=l;
        hid=10303;
        id=hid;
        name="秽土斑";
    }
}
