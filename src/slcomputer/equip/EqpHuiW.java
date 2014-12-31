/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpHuiW extends Equip{
    public EqpHuiW(){
        super();
        level=1;
        id=42104;
        star=2;
        type=33;
        name="灰丸";
        tough_born=45;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=2.25;
        slot=0;
    }
    
    public EqpHuiW(int l){
        this();
        level=l;
    }
}
