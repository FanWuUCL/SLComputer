/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqMDHZ extends Equiq{
    public EquiqMDHZ(){
        this(1);
    }
    
    public EquiqMDHZ(int l){
        super();
        level=l;
        id=40131;
        star=5;
        type=0;
        name="名刀黑泽";
        att_born=330;
        def_born=255;
        attGrowth=36.3;
        defGrowth=25.5;
        slot=4;
        hideProperty[2]=5;
    }
}
