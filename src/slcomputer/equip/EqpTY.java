/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpTY extends Equip{
    public EqpTY(){
        super();
        level=1;
        id=42127;
        star=5;
        type=33;
        name="蛞蝓";
        att_born=205;
        def_born=205;
        tough_born=290;
        attGrowth=22.55;
        defGrowth=22.55;
        toughGrowth=14.5;
        slot=3;
        hideProperty[2]=3;
    }
    
    public EqpTY(int l){
        this();
        level=l;
    }
}
