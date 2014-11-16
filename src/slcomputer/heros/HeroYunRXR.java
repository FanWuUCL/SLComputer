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
public class HeroYunRXR extends Hero{
    public HeroYunRXR(){
        this(1);
    }
    
    public HeroYunRXR(int l){
        super();
        level=l;
        hid=10175;
        id=hid;
        att_born=75;
        def_born=56;
        attGrowth=7.73;
        defGrowth=5.77;
        name="云忍下忍";
        star=1;
        style=7;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=0;
    }
}
