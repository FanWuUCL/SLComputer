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
public class HeroHYMR_6 extends HeroHYMR{
    public HeroHYMR_6(){
        this(1);
    }
    
    public HeroHYMR_6(int l){
        super();
        level=l;
        hid=10315;
        id=hid+1000;
        name="火影鸣人";
    }
}
