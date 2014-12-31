/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpGN extends Equip{
    public EqpGN(){
        super();
        level=1;
        id=42135;
        star=4;
        type=33;
        name="公牛";
        tough_born=200;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=10;
        slot=3;
        hideProperty[2]=2;
    }
    
    public EqpGN(int l){
        this();
        level=l;
    }
}
