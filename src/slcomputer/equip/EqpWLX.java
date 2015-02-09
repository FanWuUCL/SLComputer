/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpWLX extends Equip{
    public EqpWLX(){
        super();
        level=1;
        id=42111;
        eid=id;
        star=3;
        type=33;
        name="乌鲁西";
        tough_born=75;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=3.75;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpWLX(int l){
        this();
        level=l;
    }
}
