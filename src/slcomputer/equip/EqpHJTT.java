/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpHJTT extends Equip{
    public EqpHJTT(){
        super();
        level=1;
        id=42998;
        star=2;
        type=33;
        name="黄金豚豚";
        tough_born=1;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=1;
        slot=0;
    }
    
    public EqpHJTT(int l){
        this();
        level=l;
    }
}
