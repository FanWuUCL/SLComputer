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
public class HeroHuangT extends Hero{
    public HeroHuangT(){
        this(1);
    }
    
    public HeroHuangT(int l){
        super();
        level=l;
        hid=10311;
        id=hid;
        name="黄土";
    }
}
