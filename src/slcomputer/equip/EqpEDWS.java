/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpEDWS extends Equip{
    public EqpEDWS(){
        super();
        level=1;
        id=42129;
        eid=id;
        star=5;
        type=33;
        name="二代万蛇";
        att_born=215;
        def_born=215;
        tough_born=310;
        attGrowth=23.65;
        defGrowth=23.65;
        toughGrowth=15.5;
        slot=3;
        hideProperty[2]=3;
    }
    
    public EqpEDWS(int l){
        this();
        level=l;
    }
}
