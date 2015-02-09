/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpWH extends Equip{
    public EqpWH(){
        super();
        level=1;
        id=42110;
        eid=id;
        star=3;
        type=33;
        name="乌黑";
        tough_born=72;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=3.6;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpWH(int l){
        this();
        level=l;
    }
}
