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
public class HeroYC extends Hero{
    public HeroYC(){
        this(1);
    }
    
    public HeroYC(int l){
        super();
        level=l;
        hid=10278;
        id=hid;
        name="叶仓";
    }
}
