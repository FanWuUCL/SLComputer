/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpHMLi extends Equip{
    public EqpHMLi(){
        super();
        level=1;
        id=42118;
        star=3;
        type=33;
        name="蛤蟆力";
        tough_born=90;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=4.5;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpHMLi(int l){
        this();
        level=l;
    }
}
