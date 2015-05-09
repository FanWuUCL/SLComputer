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
public class HeroBLH extends Hero{
    public HeroBLH(){
        this(1);
    }
    
    public HeroBLH(int l){
        super();
        level=l;
        hid=10279;
        id=hid;
        name="卑留呼";
    }
}
