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
public class HeroZYZW extends Hero{
    public HeroZYZW(){
        this(1);
    }
    
    public HeroZYZW(int l){
        super();
        level=l;
        hid=10256;
        id=hid;
        name="咒印重吾";
    }
}
