/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqCTJ extends Equip{
    public EquiqCTJ(){
        this(1);
    }
    
    public EquiqCTJ(int l){
        super();
        level=l;
        id=40120;
        eid=id;
        star=4;
        type=0;
        name="草薙剑";
        att_born=211;
        attGrowth=22.16;
        slot=3;
        hideProperty[2]=3;
    }
}
