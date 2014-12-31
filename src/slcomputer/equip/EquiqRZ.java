/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqRZ extends Equip{
    public EquiqRZ(){
        this(1);
    }
    
    public EquiqRZ(int l){
        super();
        level=l;
        id=40106;
        star=3;
        type=0;
        name="忍杖";
        att_born=120;
        attGrowth=12.6;
        slot=2;
        hideProperty[0]=135;
    }
}
