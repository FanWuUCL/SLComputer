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
public class HeroXWSH_6 extends HeroXWSH{
    public HeroXWSH_6(){
        this(1);
    }
    
    public HeroXWSH_6(int l){
        super();
        level=l;
        hid=10248;
        id=hid+1000;
        name="漩涡水户";
    }
}
