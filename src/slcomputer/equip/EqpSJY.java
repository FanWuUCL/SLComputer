/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpSJY extends Equip{
    public EqpSJY(){
        super();
        level=1;
        id=42126;
        eid=id;
        star=4;
        type=33;
        name="山椒鱼";
        tough_born=160;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=8;
        slot=3;
        hideProperty[2]=2;
    }
    
    public EqpSJY(int l){
        this();
        level=l;
    }
}
