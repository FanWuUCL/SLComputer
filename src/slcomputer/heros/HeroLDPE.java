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
public class HeroLDPE extends Hero{
    public HeroLDPE(){
        this(1);
    }
    
    public HeroLDPE(int l){
        super();
        level=l;
        hid=10282;
        id=hid;
        name="六道佩恩";
    }
}
