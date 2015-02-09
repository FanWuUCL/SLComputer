/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpBSXR extends Equip{
    public EqpBSXR(){
        super();
        level=1;
        id=42140;
        eid=id;
        star=5;
        type=33;
        name="白蛇仙人";
        att_born=225;
        def_born=225;
        tough_born=330;
        attGrowth=24.75;
        defGrowth=24.75;
        toughGrowth=16.5;
        slot=4;
        hideProperty[2]=3;
    }
    
    public EqpBSXR(int l){
        this();
        level=l;
    }
}
