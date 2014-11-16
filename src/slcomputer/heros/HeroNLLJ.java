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
public class HeroNLLJ extends Hero{
    public HeroNLLJ(){
        this(1);
    }
    
    public HeroNLLJ(int l){
        super();
        level=l;
        hid=10189;
        id=hid;
        att_born=107;
        def_born=143;
        attGrowth=10.81;
        defGrowth=14.44;
        name="奈良鹿久";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
