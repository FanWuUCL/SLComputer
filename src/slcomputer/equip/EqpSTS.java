/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpSTS extends Equip{
    public EqpSTS(){
        super();
        level=1;
        id=42115;
        star=4;
        type=33;
        name="三头蛇";
        tough_born=120;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=6;
        slot=2;
        hideProperty[2]=2;
    }
    
    public EqpSTS(int l){
        this();
        level=l;
    }
}
