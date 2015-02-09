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
public class HeroCJRZ_6 extends HeroCJRZ{
    public HeroCJRZ_6(){
        this(1);
    }
    
    public HeroCJRZ_6(int l){
        super();
        level=l;
        hid=10323;
        id=hid+1000;
        name="春节忍者";
    }
}
