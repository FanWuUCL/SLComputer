/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpHML extends Equip{
    public EqpHML(){
        super();
        level=1;
        id=42117;
        eid=id;
        star=3;
        type=33;
        name="蛤蟆龙";
        tough_born=87;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=4.35;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpHML(int l){
        this();
        level=l;
    }
}
