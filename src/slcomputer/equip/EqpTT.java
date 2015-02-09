/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpTT extends Equip{
    public EqpTT(){
        super();
        level=1;
        id=42101;
        eid=id;
        star=1;
        type=33;
        name="豚豚";
        tough_born=25;
        attGrowth=10;
        defGrowth=0;
        toughGrowth=1.25;
        slot=0;
    }
    
    public EqpTT(int l){
        this();
        level=l;
    }
}
