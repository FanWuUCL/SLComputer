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
public class HeroQSFJ extends Hero{
    public HeroQSFJ(){
        this(1);
    }
    
    public HeroQSFJ(int l){
        super();
        level=l;
        hid=10101;
        id=hid;
        att_born=208;
        def_born=161;
        attGrowth=21.84;
        defGrowth=16.91;
        name="千手扉间";
        star=5;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
