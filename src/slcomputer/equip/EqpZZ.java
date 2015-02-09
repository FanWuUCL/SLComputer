/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpZZ extends Equip{
    public EqpZZ(){
        super();
        level=1;
        id=42102;
        eid=id;
        star=2;
        type=33;
        name="蜘蛛";
        tough_born=35;
        attGrowth=0;
        defGrowth=10;
        toughGrowth=1.75;
        slot=0;
    }
    
    public EqpZZ(int l){
        this();
        level=l;
    }
}
