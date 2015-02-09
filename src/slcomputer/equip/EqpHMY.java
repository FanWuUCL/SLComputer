/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpHMY extends Equip{
    public EqpHMY(){
        super();
        level=1;
        id=42121;
        eid=id;
        star=3;
        type=33;
        name="蛤蟆寅";
        tough_born=93;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=4.65;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpHMY(int l){
        this();
        level=l;
    }
}
