/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpHMJ extends Equip{
    public EqpHMJ(){
        super();
        level=1;
        id=42116;
        eid=id;
        star=3;
        type=33;
        name="蛤蟆吉";
        tough_born=84;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=4.2;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpHMJ(int l){
        this();
        level=l;
    }
}
