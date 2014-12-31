/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpHMJian extends Equip{
    public EqpHMJian(){
        super();
        level=1;
        id=42119;
        star=4;
        type=33;
        name="蛤蟆健";
        tough_born=144;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=7.2;
        slot=2;
        hideProperty[2]=2;
    }
    
    public EqpHMJian(int l){
        this();
        level=l;
    }
}
