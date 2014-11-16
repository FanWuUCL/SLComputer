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
public class HeroLDB extends Hero{
    public HeroLDB(){
        this(1);
    }
    
    public HeroLDB(int l){
        super();
        level=l;
        hid=10247;
        id=hid;
        name="六道斑";
    }
}
