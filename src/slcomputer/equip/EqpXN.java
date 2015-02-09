/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpXN extends Equip{
    public EqpXN(){
        super();
        level=1;
        id=42136;
        eid=id;
        star=4;
        type=33;
        name="犀牛";
        tough_born=208;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=10.4;
        slot=3;
        hideProperty[2]=2;
    }
    
    public EqpXN(int l){
        this();
        level=l;
    }
}
