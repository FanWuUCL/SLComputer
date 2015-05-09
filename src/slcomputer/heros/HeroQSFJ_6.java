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
public class HeroQSFJ_6 extends HeroQSFJ{
    public HeroQSFJ_6(){
        this(1);
    }
    
    public HeroQSFJ_6(int l){
        super();
        level=l;
        hid=10101;
        id=hid+1000;
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
