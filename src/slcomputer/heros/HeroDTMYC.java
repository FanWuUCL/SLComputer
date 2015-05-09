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
public class HeroDTMYC extends Hero{
    public HeroDTMYC(){
        this(1);
    }
    
    public HeroDTMYC(int l){
        super();
        level=l;
        hid=10318;
        id=hid;
        name="大筒木羽村";
    }
}
