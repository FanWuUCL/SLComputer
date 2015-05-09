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
public class HeroSRLW extends Hero{
    public HeroSRLW(){
        this(1);
    }
    
    public HeroSRLW(int l){
        super();
        level=l;
        hid=10272;
        id=hid;
        name="上忍鹿丸";
    }
}
