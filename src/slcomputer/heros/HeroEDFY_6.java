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
public class HeroEDFY_6 extends HeroEDFY{
    public HeroEDFY_6(){
        this(1);
    }
    
    public HeroEDFY_6(int l){
        super();
        level=l;
        hid=10314;
        id=hid+1000;
        name="二代风影";
    }
}
