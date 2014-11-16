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
public class HeroXWSH extends Hero{
    public HeroXWSH(){
        this(1);
    }
    
    public HeroXWSH(int l){
        super();
        level=l;
        hid=10248;
        id=hid;
        name="漩涡水户";
    }
}
