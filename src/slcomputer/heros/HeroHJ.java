/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

/**
 *
 * @author J
 */
public class HeroHJ extends Hero{
    public HeroHJ(){
        this(1);
    }
    
    public HeroHJ(int l){
        super();
        level=l;
        hid=19998;
        id=hid;
        att_born=1;
        def_born=1;
        attGrowth=1;
        defGrowth=1;
        name="黑绝";
        star=2;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
    
}
