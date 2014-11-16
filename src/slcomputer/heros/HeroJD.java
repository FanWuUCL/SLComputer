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
public class HeroJD extends Hero{
    public HeroJD(){
        this(1);
    }
    
    public HeroJD(int l){
        super();
        level=l;
        hid=10136;
        id=hid;
        att_born=116;
        def_born=155;
        attGrowth=11.72;
        defGrowth=15.66;
        name="角都";
        star=4;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
