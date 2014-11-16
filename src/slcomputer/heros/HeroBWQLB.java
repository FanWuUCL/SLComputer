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
public class HeroBWQLB extends Hero{
    public HeroBWQLB(){
        this(1);
    }
    
    public HeroBWQLB(int l){
        super();
        level=l;
        hid=10236;
        id=hid;
        name="八尾奇拉比";
    }
}
