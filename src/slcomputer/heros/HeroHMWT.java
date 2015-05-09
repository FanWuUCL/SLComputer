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
public class HeroHMWT extends Hero{
    public HeroHMWT(){
        this(1);
    }
    
    public HeroHMWT(int l){
        super();
        level=l;
        hid=10263;
        id=hid;
        name="蛤蟆文太";
    }
}
