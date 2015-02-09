/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpBSL extends Equip{
    public EqpBSL(){
        super();
        level=1;
        id=42132;
        eid=id;
        star=4;
        type=33;
        name="变色龙";
        tough_born=176;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=8.8;
        slot=3;
        hideProperty[2]=2;
    }
    
    public EqpBSL(int l){
        this();
        level=l;
    }
}
