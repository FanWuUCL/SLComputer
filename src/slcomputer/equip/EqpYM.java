/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpYM extends Equip{
    public EqpYM(){
        super();
        level=1;
        id=42144;
        star=5;
        type=33;
        name="猿魔";
        att_born=245;
        def_born=245;
        tough_born=370;
        attGrowth=26.95;
        defGrowth=26.95;
        toughGrowth=18.5;
        slot=4;
        hideProperty[2]=3;
    }
    
    public EqpYM(int l){
        this();
        level=l;
    }
}
