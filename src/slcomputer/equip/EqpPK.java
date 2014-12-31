/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpPK extends Equip{
    public EqpPK(){
        super();
        level=1;
        id=42113;
        star=3;
        type=33;
        name="帕克";
        tough_born=81;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=4.05;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpPK(int l){
        this();
        level=l;
    }
}
