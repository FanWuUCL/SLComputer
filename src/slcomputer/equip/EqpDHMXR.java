/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpDHMXR extends Equip{
    public EqpDHMXR(){
        super();
        level=1;
        id=42143;
        eid=id;
        star=5;
        type=33;
        name="大蛤蟆仙人";
        att_born=240;
        def_born=240;
        tough_born=360;
        attGrowth=26.4;
        defGrowth=26.4;
        toughGrowth=18;
        slot=4;
        hideProperty[2]=3;
    }
    
    public EqpDHMXR(int l){
        this();
        level=l;
    }
}
