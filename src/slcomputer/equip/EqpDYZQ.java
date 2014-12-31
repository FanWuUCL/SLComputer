/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpDYZQ extends Equip{
    public EqpDYZQ(){
        super();
        level=1;
        id=42133;
        star=4;
        type=33;
        name="地狱之犬";
        tough_born=184;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=9.2;
        slot=3;
        hideProperty[2]=2;
    }
    
    public EqpDYZQ(int l){
        this();
        level=l;
    }
}
