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
public class HeroCDFY extends Hero{
    public HeroCDFY(){
        this(1);
    }
    
    public HeroCDFY(int l){
        super();
        level=l;
        hid=10313;
        id=hid;
        name="初代风影";
    }
}
