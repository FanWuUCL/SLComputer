/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpHJPK extends Equip{
    public EqpHJPK(){
        super();
        level=1;
        id=42999;
        star=3;
        type=33;
        name="黄金帕克";
        tough_born=1;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=1;
        slot=0;
    }
    
    public EqpHJPK(int l){
        this();
        level=l;
    }
}
