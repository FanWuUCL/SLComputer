/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpHMWT extends Equip{
    public EqpHMWT(){
        super();
        level=1;
        id=42130;
        eid=id;
        star=5;
        type=33;
        name="蛤蟆文太";
        att_born=220;
        def_born=220;
        tough_born=320;
        attGrowth=24.2;
        defGrowth=24.2;
        toughGrowth=16;
        slot=3;
        hideProperty[2]=3;
    }
    
    public EqpHMWT(int l){
        this();
        level=l;
    }
}
