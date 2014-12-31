/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpAJN extends Equip{
    public EqpAJN(){
        super();
        level=1;
        id=42108;
        star=3;
        type=33;
        name="阿基诺";
        tough_born=66;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=3.3;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpAJN(int l){
        this();
        level=l;
    }
}
