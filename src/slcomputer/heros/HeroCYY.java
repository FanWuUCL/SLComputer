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
public class HeroCYY extends Hero{
    public HeroCYY(){
        this(1);
    }
    
    public HeroCYY(int l){
        super();
        level=l;
        hid=10143;
        id=hid;
        att_born=113;
        def_born=150;
        attGrowth=11.41;
        defGrowth=15.15;
        name="春野樱";
        star=3;
        style=0;
        gender=0;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
