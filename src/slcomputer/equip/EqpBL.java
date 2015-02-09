/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpBL extends Equip{
    public EqpBL(){
        super();
        level=1;
        id=42112;
        eid=id;
        star=3;
        type=33;
        name="布鲁";
        tough_born=78;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=3.9;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpBL(int l){
        this();
        level=l;
    }
}
