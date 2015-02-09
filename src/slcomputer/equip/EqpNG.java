/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpNG extends Equip{
    public EqpNG(){
        super();
        level=1;
        id=42124;
        eid=id;
        star=3;
        type=33;
        name="怒鬼";
        tough_born=99;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=7.95;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpNG(int l){
        this();
        level=l;
    }
}
