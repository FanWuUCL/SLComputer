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
public class HeroDLY extends Hero{
    public HeroDLY(){
        this(1);
    }
    
    public HeroDLY(int l){
        super();
        level=l;
        hid=10149;
        id=hid;
        att_born=135;
        def_born=101;
        attGrowth=13.64;
        defGrowth=10.2;
        name="达鲁伊";
        star=3;
        style=7;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
