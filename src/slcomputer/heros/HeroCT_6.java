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
public class HeroCT_6 extends HeroCT{
    public HeroCT_6(){
        this(1);
    }
    
    public HeroCT_6(int l){
        super();
        level=l;
        hid=10239;
        id=hid+1000;
        name="赤土";
    }
}
