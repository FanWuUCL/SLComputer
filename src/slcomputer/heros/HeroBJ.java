/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

/**
 *
 * @author J
 */
public class HeroBJ extends Hero{
    public HeroBJ(){
        this(1);
    }
    
    public HeroBJ(int l){
        super();
        level=l;
        hid=19999;
        id=hid;
        att_born=1;
        def_born=1;
        attGrowth=1;
        defGrowth=1;
        name="白绝";
        star=3;
        style=6;
        gender=1;
        if(att_born>def_born){
            attOrDef=1;
        }
        property=1;
    }
}
