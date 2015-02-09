/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpBSK extends Equip{
    public EqpBSK(){
        super();
        level=1;
        id=42107;
        eid=id;
        star=3;
        type=33;
        name="比斯克";
        tough_born=63;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=3.15;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpBSK(int l){
        this();
        level=l;
    }
}
