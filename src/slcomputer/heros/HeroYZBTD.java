/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import slcomputer.Hero;

/**
 *
 * @author J
 */
public class HeroYZBTD extends Hero{
    public HeroYZBTD(){
        this(1);
    }
    
    public HeroYZBTD(int l){
        super();
        level=l;
        hid=10298;
        id=hid;
        name="宇智波田岛";
    }
}
