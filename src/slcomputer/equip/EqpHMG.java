/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpHMG extends Equip{
    public EqpHMG(){
        super();
        level=1;
        id=42120;
        star=4;
        type=33;
        name="蛤蟆广";
        tough_born=152;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=7.6;
        slot=2;
        hideProperty[2]=2;
    }
    
    public EqpHMG(int l){
        this();
        level=l;
    }
}
