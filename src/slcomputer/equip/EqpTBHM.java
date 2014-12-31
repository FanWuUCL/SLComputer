/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpTBHM extends Equip{
    public EqpTBHM(){
        super();
        level=1;
        id=42122;
        star=4;
        type=33;
        name="铁臂蛤蟆";
        tough_born=128;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=6.4;
        slot=2;
        hideProperty[2]=2;
    }
    
    public EqpTBHM(int l){
        this();
        level=l;
    }
}
