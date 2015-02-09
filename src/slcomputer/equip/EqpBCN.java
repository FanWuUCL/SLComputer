/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpBCN extends Equip{
    public EqpBCN(){
        super();
        level=1;
        id=42134;
        eid=id;
        star=4;
        type=33;
        name="八咫鸟";
        tough_born=192;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=9.6;
        slot=3;
        hideProperty[2]=2;
    }
    
    public EqpBCN(int l){
        this();
        level=l;
    }
}
