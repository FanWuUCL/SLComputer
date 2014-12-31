/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpCW extends Equip{
    public EqpCW(){
        super();
        level=1;
        id=42105;
        star=2;
        type=33;
        name="赤丸";
        tough_born=50;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=2.5;
        slot=0;
    }
    
    public EqpCW(int l){
        this();
        level=l;
    }
}
