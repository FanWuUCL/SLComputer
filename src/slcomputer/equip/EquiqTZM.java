/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqTZM extends Equip{
    public EquiqTZM(){
        this(1);
    }
    
    public EquiqTZM(int l){
        super();
        level=l;
        id=40132;
        star=5;
        type=0;
        name="天沼矛";
        att_born=350;
        attGrowth=38.75;
        def_born=262;
        defGrowth=27.51;
        slot=4;
        hideProperty[2]=5;
    }
}
