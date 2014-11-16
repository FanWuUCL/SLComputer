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
public class HeroHTQD extends Hero{
    public HeroHTQD(){
        this(1);
    }
    
    public HeroHTQD(int l){
        super();
        level=l;
        hid=10289;
        id=hid;
        name="秽土千代";
    }
}
