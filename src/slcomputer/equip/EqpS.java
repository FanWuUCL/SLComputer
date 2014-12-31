/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpS extends Equip{
    public EqpS(){
        super();
        level=1;
        id=42139;
        star=4;
        type=33;
        name="蜃";
        tough_born=232;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=11.6;
        slot=3;
        hideProperty[2]=2;
    }
    
    public EqpS(int l){
        this();
        level=l;
    }
}
