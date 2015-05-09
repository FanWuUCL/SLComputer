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
public class HeroYNZW extends Hero{
    public HeroYNZW(){
        this(1);
    }
    
    public HeroYNZW(int l){
        super();
        level=l;
        hid=10191;
        id=hid;
        att_born=155;
        def_born=116;
        attGrowth=15.66;
        defGrowth=11.72;
        name="油女志微";
        star=4;
        style=0;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=2;
    }
}
