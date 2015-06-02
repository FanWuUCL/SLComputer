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
public class HeroSNB_6 extends HeroSNB{
    public HeroSNB_6(){
        this(1);
    }
    
    public HeroSNB_6(int l){
        super();
        level=l;
        hid=10330;
        id=hid+1000;
        name="少年斑";
    }
}
