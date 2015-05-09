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
public class HeroSanDFY extends Hero{
    public HeroSanDFY(){
        this(1);
    }
    
    public HeroSanDFY(int l){
        super();
        level=l;
        hid=10271;
        id=hid;
        name="三代风影";
    }
}
