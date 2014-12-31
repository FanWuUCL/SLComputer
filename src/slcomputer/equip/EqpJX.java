/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpJX extends Equip{
    public EqpJX(){
        super();
        level=1;
        id=42131;
        star=4;
        type=33;
        name="巨蟹";
        tough_born=168;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=8.4;
        slot=3;
        hideProperty[2]=2;
    }
    
    public EqpJX(int l){
        this();
        level=l;
    }
}
