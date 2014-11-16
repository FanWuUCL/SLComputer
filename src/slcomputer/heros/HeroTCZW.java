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
public class HeroTCZW extends Hero{
    public HeroTCZW(){
        this(1);
    }
    
    public HeroTCZW(int l){
        super();
        level=l;
        hid=10124;
        id=hid;
        att_born=126;
        def_born=95;
        attGrowth=12.73;
        defGrowth=9.6;
        name="天秤重吾";
        star=3;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=4;
    }
}
