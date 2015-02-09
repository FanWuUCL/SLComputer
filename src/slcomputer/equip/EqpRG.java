/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpRG extends Equip{
    public EqpRG(){
        super();
        level=1;
        id=42123;
        eid=id;
        star=3;
        type=33;
        name="忍龟";
        tough_born=96;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=4.8;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpRG(int l){
        this();
        level=l;
    }
}
