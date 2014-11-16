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
public class HeroDSW_6 extends HeroDSW{
    public HeroDSW_6(){
        this(1);
    }
    
    public HeroDSW_6(int l){
        super();
        level=l;
        hid=10105;
        id=11105;
        att_born=159;
        def_born=205;
        attGrowth=16.7;
        defGrowth=21.53;
        name="大蛇丸";
        star=5;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=3;
    }
}
