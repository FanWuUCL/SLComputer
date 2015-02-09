/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpLY extends Equip{
    public EqpLY(){
        super();
        level=1;
        id=42114;
        eid=id;
        star=4;
        type=33;
        name="镰鼬";
        tough_born=136;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=6.8;
        slot=2;
        hideProperty[2]=2;
    }
    
    public EqpLY(int l){
        this();
        level=l;
    }
}
