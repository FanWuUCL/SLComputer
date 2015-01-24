/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpWDMX extends Equip{
    public EqpWDMX(){
        super();
        level=1;
        id=42145;
        star=5;
        type=33;
        name="外道魔像";
        att_born=300;
        def_born=300;
        tough_born=400;
        attGrowth=33;
        defGrowth=33;
        toughGrowth=20;
        slot=4;
        hideProperty[2]=4;
    }
    
    public EqpWDMX(int l){
        this();
        level=l;
    }
}
