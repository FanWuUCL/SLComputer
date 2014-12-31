/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpMM extends Equip{
    public EqpMM(){
        super();
        level=1;
        id=42125;
        star=5;
        type=33;
        name="梦貘";
        att_born=200;
        def_born=200;
        tough_born=280;
        attGrowth=22;
        defGrowth=22;
        toughGrowth=14;
        slot=3;
        hideProperty[2]=3;
    }
    
    public EqpMM(int l){
        this();
        level=l;
    }
}
