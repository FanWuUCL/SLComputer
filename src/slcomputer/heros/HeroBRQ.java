/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import slcomputer.Hero;
import slcomputer.Team;

/**
 *
 * @author J
 */
public class HeroBRQ extends Hero{
    public HeroBRQ(){
        this(1);
    }
    
    public HeroBRQ(int l){
        super();
        level=l;
        hid=10262;
        id=hid;
        name="八忍犬";
    }
}
