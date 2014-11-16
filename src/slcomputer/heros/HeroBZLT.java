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
public class HeroBZLT extends Hero{
    public HeroBZLT(){
        this(1);
    }
    
    public HeroBZLT(int l){
        super();
        level=l;
        hid=10200;
        id=hid;
        att_born=97;
        def_born=129;
        attGrowth=9.8;
        defGrowth=13.03;
        name="并足雷同";
        star=3;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
