/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpXB extends Equip{
    public EqpXB(){
        super();
        level=1;
        id=42106;
        eid=id;
        star=3;
        type=33;
        name="西巴";
        tough_born=60;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=3;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpXB(int l){
        this();
        level=l;
    }
}
