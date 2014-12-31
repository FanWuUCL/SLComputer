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
public class HeroCDSY extends Hero{
    public HeroCDSY(){
        this(1);
    }
    
    public HeroCDSY(int l){
        super();
        level=l;
        hid=10307;
        id=hid;
        name="初代水影";
    }
}
