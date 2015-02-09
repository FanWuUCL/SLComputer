/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpHW extends Equip{
    public EqpHW(){
        super();
        level=1;
        id=42103;
        eid=id;
        star=2;
        type=33;
        name="黑丸";
        tough_born=40;
        attGrowth=10;
        defGrowth=10;
        toughGrowth=2;
        slot=0;
    }
    
    public EqpHW(int l){
        this();
        level=l;
    }
}
