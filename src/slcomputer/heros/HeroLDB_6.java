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
public class HeroLDB_6 extends HeroLDB{
    public HeroLDB_6(){
        this(1);
    }
    
    public HeroLDB_6(int l){
        super();
        level=l;
        hid=10247;
        id=hid+1000;
        name="六道斑";
    }
}
