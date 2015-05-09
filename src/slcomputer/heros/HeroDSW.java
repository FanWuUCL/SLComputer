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
public class HeroDSW extends Hero{
    public HeroDSW(){
        this(1);
    }
    
    public HeroDSW(int l){
        super();
        level=l;
        hid=10105;
        id=hid;
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
