/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpXM extends Equip{
    public EqpXM(){
        super();
        level=1;
        id=42137;
        eid=id;
        star=4;
        type=33;
        name="熊猫";
        tough_born=216;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=10.8;
        slot=3;
        hideProperty[2]=2;
    }
    
    public EqpXM(int l){
        this();
        level=l;
    }
}
