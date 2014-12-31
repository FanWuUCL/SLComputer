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
public class HeroEDFY extends Hero{
    public HeroEDFY(){
        this(1);
    }
    
    public HeroEDFY(int l){
        super();
        level=l;
        hid=10314;
        id=hid;
        name="二代风影";
    }
}
